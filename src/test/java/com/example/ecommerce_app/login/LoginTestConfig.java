package com.example.ecommerce_app.login;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.ecommerce_app.user.ApplicationUser;

public class LoginTestConfig {

    static final ApplicationUser testUser_ToStore = new ApplicationUser(
        "password",
        "email@email.com",
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testUser_Valid = new ApplicationUser(
        "password",
        "email@email.com",
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testUser_InvalidEmail = new ApplicationUser(
        "password",
        "differentEmail@email.com",
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testUser_InvalidPassword = new ApplicationUser(
        "differentPassword",
        "email@email.com",
        Set.of(),
        Set.of()
    );

}
