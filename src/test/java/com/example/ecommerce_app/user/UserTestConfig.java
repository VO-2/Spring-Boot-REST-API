package com.example.ecommerce_app.user;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserTestConfig {

    @Bean
    protected ApplicationUser sampleApplicationUser1() {
        return new ApplicationUser(
            "username",
            "password",
            "email@email.com",
            true,
            true,
            true,
            true,
            List.of());
    }
}
