package com.example.ecommerce_app.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.ecommerce_app.security.LoginController;
import com.example.ecommerce_app.user.ApplicationUserRepository;
import static com.example.ecommerce_app.login.LoginTestConfig.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginIntegrationTest {
    
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private LoginController loginController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeAll 
    void init() {
        testUser_ToStore.setPassword(passwordEncoder.encode(testUser_ToStore.getPassword()));
        applicationUserRepository.save(testUser_ToStore);
    }

    @Test
    void testLogin() {
        assertTrue(testUser_ToStore.equals(loginController.login(testUser_Valid)));
    }

    @Test
    void testLogin_NoUserFound() {
        assertThrows(NoSuchElementException.class, () -> loginController.login(testUser_InvalidEmail));
    }

    @Test
    void testLogin_PasswordMismatch() {
        assertThrows(IllegalArgumentException.class, () -> loginController.login(testUser_InvalidPassword));
    }


}
