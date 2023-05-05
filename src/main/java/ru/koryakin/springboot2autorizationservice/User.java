package ru.koryakin.springboot2autorizationservice;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import ru.koryakin.springboot2autorizationservice.repository.Authorities;

import java.util.Arrays;
import java.util.List;

public class User {

    @NotBlank
    @Min(2)
    @Max(20)
    private final String user;
    @NotBlank
    @Min(4)
    @Max(20)
    private final String password;
    List<Authorities> authorities;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public void setAuthorities(Authorities[] authorities) {
        this.authorities = Arrays.asList(authorities);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }
}
