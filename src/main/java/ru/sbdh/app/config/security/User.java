package ru.sbdh.app.config.security;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */

public class User {
    private int userId;
    private String email; // In lower case
    private String password; // md5

    private static volatile int currentId = 0;

    private int getNextId() {
        synchronized (User.class) {
            return ++currentId;
        }
    }

    private UserRole role;

    public User(final String email, final String password, final UserRole role) {
        this.userId = getNextId();
        this.email = (email.contains("@") ? email : email + "@uvb.main.izh").toLowerCase();
        this.password = password;
        this.role = role;
    }

    public User() {
        //
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        return (userId + " : " + email).hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return userId == user.userId;
    }
}
