package ru.koryakin.springboot2autorizationservice.service;

import ru.koryakin.springboot2autorizationservice.User;
import ru.koryakin.springboot2autorizationservice.exceptions.InvalidCredentials;
import ru.koryakin.springboot2autorizationservice.exceptions.UnauthorizedUser;
import ru.koryakin.springboot2autorizationservice.repository.Authorities;
import ru.koryakin.springboot2autorizationservice.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        String userName = user.getUser();
        String password = user.getPassword();
        if (isEmpty(userName) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + userName);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}