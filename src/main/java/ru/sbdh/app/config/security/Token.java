package ru.sbdh.app.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
public final class Token {
    private static final long VALIDITY = 1000 * 60 * 60 * 24; // Срок действия токена - 1 сутки
    private static final String SECRET_KEY = "75798afa69b880fe5a07713fe40d5983";
    private static final Logger LOGGER = LoggerFactory.getLogger(Token.class);

    private Token() {
        //
    }

    static String getSecretKey() {
        return SECRET_KEY;
    }

    /**
     * Получаем токен для пользователя в случае успешной авторизации.
     *
     * @param email    email
     * @param password пароль
     * @return токен
     */
    public static String getToken(final String email, final String password) throws Exception {
        if (email == null || password == null) {
            throw new Exception("Заполните логин и пароль");
        }
        String emailCor = email.contains("@") ? email.toLowerCase() : email.toLowerCase() + "@uvb.main.izh";

        boolean isUser = UserService.isADUser(emailCor, password);
        //|| UserService.checkUser(emailCor, password);
        if (!isUser) {
            throw new Exception("Проверьте логин и пароль");
        }

        UserRole role = UserService.getRole(emailCor);

        String token = Jwts.builder()
                .setSubject(emailCor)
                .claim("roles", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + VALIDITY))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

        LOGGER.info("The token is received for the user " + emailCor);

        return "{\"token\" : \"" + token + "\"}";
    }
}
