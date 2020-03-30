package ru.sbdh.app.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
public class JwtFilter extends GenericFilterBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);

    private String getTokenFromCookies(final Cookie[] cookies) {
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        String token = null;
        Claims claims = null;
        UserRole role = UserRole.UNREGISTERED;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("jwtTokenDG")) {
                try {
                    Claims claims1 = Jwts.parser().setSigningKey(Token.getSecretKey()).parseClaimsJws(cookie.getValue()).getBody();
                    if (claims == null) {
                        claims = claims1;
                        token = cookie.getValue();
                        role = UserRole.byName(claims.get("roles").toString());
                    } else {
                        UserRole role1 = UserRole.byName(claims1.get("roles").toString());
                        if (role1.ordinal() < role.ordinal()) {
                            claims = claims1;
                            token = cookie.getValue();
                            role = role1;
                        }
                    }
                } catch (Exception e) { // NOPMD
                }
            }
        }
        return token;
    }

    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        //copyCookie(request, response);
        String cookieToken = getTokenFromCookies(request.getCookies());
        try {
            if ("OPTIONS".equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);

                chain.doFilter(req, res);
            } else {
                if ((authHeader == null || !authHeader.startsWith("Bearer ")) && cookieToken == null) {
                    throw new Exception("Missing or invalid Authorization header (" + request.getRemoteAddr() + ")");
                }

                final String token = authHeader == null || !authHeader.startsWith("Bearer ") ? cookieToken : authHeader.substring(7);

                try {
                    final Claims claims = Jwts.parser().setSigningKey(Token.getSecretKey())
                            .parseClaimsJws(token).getBody();
                    request.setAttribute("claims", claims);
                } catch (Exception e) {
                    throw new Exception("Invalid token (" + request.getRemoteAddr() + ")", e);
                }

                chain.doFilter(req, res);
            }
        } catch (Exception e) {
            errorHandler(e);
        }
    }

    private void errorHandler(final Exception e) {
        LOGGER.error("Ошибка авторизации " + e.toString());
    }
}
