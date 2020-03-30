package ru.sbdh.app.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.config.security.Token;

import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    @Value("${spring.security.ad.url}")
    private String ldapUrl;

    @Autowired
    @Value("${spring.security.ad.domain}")
    private String ldapDomain;

    @PostMapping("/api/auth/authenticate")
    public String authenticate(@RequestBody Map<Object, String> body) throws Exception {
//        ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider = new
//                ActiveDirectoryLdapAuthenticationProvider(ldapDomain, ldapUrl);
       return Token.getToken(body.get("username"), body.get("password"));
    }
}
