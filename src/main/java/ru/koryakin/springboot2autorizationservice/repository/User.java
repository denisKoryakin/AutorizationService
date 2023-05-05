package ru.koryakin.springboot2autorizationservice.repository;

import java.util.Arrays;
import java.util.List;

public class User {

    private final String user;
    private final String password;
    List<Authorities> authorities;

    protected User(String user, String password, Authorities[] authorities) {
        this.user = user;
        this.password = password;
        this.authorities = Arrays.asList(authorities);
    }

    protected String getUser() {
        return user;
    }

    protected String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }
}
