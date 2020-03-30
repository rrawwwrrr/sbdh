package ru.sbdh.app.config.security;

import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
public enum UserRole {
    // Роли пользователя от наивысшей к наименьшей.
    ADMIN, USER, UNREGISTERED;

    public static UserRole getRole(final HttpServletRequest request) {
        Object claims = request.getAttribute("claims");
        return byName(((DefaultClaims) claims).get("roles").toString());
    }

    /**
     * Получаем роль текущего пользователя.
     *
     * @return
     */
    public static UserRole getCurrentUserRole() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
        return getRole(request);
    }

    public static UserRole byName(final String name) {
        if (name == null) {
            return UNREGISTERED;
        }
        for (UserRole role : values()) {
            if (role.name().equals(name)) {
                return role;
            }
        }
        return UNREGISTERED;
    }
}
