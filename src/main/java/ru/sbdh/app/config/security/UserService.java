package ru.sbdh.app.config.security;

import com.unboundid.ldap.sdk.*;
import com.unboundid.util.ssl.SSLUtil;
import com.unboundid.util.ssl.TrustAllTrustManager;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
public final class UserService {
    // Список пользователей в котором хранятся пользовыатели, которых нет а AD,
    private static final List<User> USERS = new ArrayList<>();

    // Группы рассылок, в одну из которых должен входить пользователь
    private static final List<String> GROUPS = new ArrayList<>();

    private static final boolean CHECK_USERS_IN_GROUPS = false; // Нужно ли проверять, что пользователи входят в группы
    private static final int LDAP_PORT = 389;
    private static final String LDAP_HOSTS = "192.168.36.130";

    static {
        GROUPS.add("Пользователи домена");
    }

    private static String filterStringTempl;
    private static final String FILTER_GROUP_BEFORE = "(memberOf=CN=";
    private static final String FILTER_GROUP_AFTER = ",CN=Users,DC=uvb,DC=main,DC=izh)";

    static {
        filterStringTempl = "(&(objectClass=user)(userPrincipalName=%s)(|" + FILTER_GROUP_BEFORE;
        filterStringTempl += String.join(FILTER_GROUP_AFTER + FILTER_GROUP_BEFORE, GROUPS);
        filterStringTempl += FILTER_GROUP_AFTER + "))";
    }

    private UserService() {
        //
    }


    /**
     * Проверка пользователя в списке сохранённых.
     *
     * @param email
     * @return
     */
    public static User findByEmail(final String email) {
        String lcEmail = email.toLowerCase();
        List<User> fUsers = USERS.stream().filter(x -> x.getEmail().equals(lcEmail)).collect(Collectors.toList());
        return fUsers.size() == 0 ? null : fUsers.get(0);
    }

    /**
     * Проверка пользователя в списке вручную добавленых пользователей.
     *
     * @param email
     * @param password
     * @return
     */
    static boolean checkUser(final String email, final String password) {
        byte[] digest;
        try {
            digest = MessageDigest.getInstance("MD5").digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        String md5Password = DatatypeConverter.printHexBinary(digest).toLowerCase();
        String lcEmail = email.toLowerCase();
        return USERS.stream().anyMatch(x -> x.getEmail().equals(lcEmail) && x.getPassword().equals(md5Password));
    }

    /**
     * Получаем имя/емэйл текущего пользователя.
     *
     * @return
     */
    public static String getCurrentUserName() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        if (request.getAttribute("claims") == null || ((DefaultClaims) request.getAttribute("claims")).get("sub") == null) {
            return "";
        }
        return ((DefaultClaims) request.getAttribute("claims")).get("sub").toString();
    }

    /**
     * Получение роли пользователя. Если пользователь не добавлен в USERS, то роль по умолчанию - USER.
     *
     * @param email
     * @return
     */
    public static UserRole getRole(final String email) {
        User user = findByEmail(email);
        return user == null ? UserRole.USER : user.getRole();
    }

    /**
     * Получаем роль текущего пользователя.
     *
     * @return
     */
    public static UserRole getCurentUserRole() {
        return UserRole.getCurrentUserRole();
    }

    /**
     * Проверка, что пользователь с таким паролем существует в Active Directory.
     * Также проверяем, что пользователь входит в нужную группу рассылки.
     *
     * @param email
     * @param password
     * @return
     */
    static boolean isADUser(final String email, final String password) {
        LDAPConnectionOptions options = new LDAPConnectionOptions();
        options.setResponseTimeoutMillis(10000);
        SSLUtil sslUtil = new SSLUtil(new TrustAllTrustManager());
//        try (LDAPConnection connection = new LDAPConnection(sslUtil.createSSLSocketFactory(), options, LDAP_HOSTS, LDAP_PORT, email, password)) {
        try (LDAPConnection connection = new LDAPConnection(options, LDAP_HOSTS, LDAP_PORT, email, password)) {
            if (!CHECK_USERS_IN_GROUPS) {
                return true;
            }
            return connection.search(
                    new SearchRequest(
                            "dc=uvb,dc=main,dc=izh",
                            SearchScope.SUB,
                            Filter.create(String.format(filterStringTempl, email))
                    )
            )
                    .getSearchEntries()
                    .size() > 0;
        } catch (LDAPException e) {
            if (e.getResultCode().intValue() == 49) { // invalid credentials
                return false;
            }
        }
        return false;
    }
}
