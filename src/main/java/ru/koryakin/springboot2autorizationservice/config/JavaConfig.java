package ru.koryakin.springboot2autorizationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.koryakin.springboot2autorizationservice.repository.UserRepository;
import ru.koryakin.springboot2autorizationservice.service.AuthorizationService;

@Configuration
public class JavaConfig {

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

}
