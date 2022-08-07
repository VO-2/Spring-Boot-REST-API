package com.example.ecommerce_app.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
public class ApplicationUserServiceTest {
    
    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private static ApplicationUserRepository applicationUserRepository;

    @Autowired
    private static ApplicationUser sampleApplicationUser1;
    
    @BeforeAll
    static void init() {
        applicationUserRepository.deleteAll();
        applicationUserRepository.save(sampleApplicationUser1);
    }

    @Test
    void loadUserByUsername_EmptyDB() {
        assertThrows(UsernameNotFoundException.class, () -> {
            applicationUserService.loadUserByUsername("");
        });
    }

    @Test
    void loadUserByUsername() {
        ApplicationUser savedUser = applicationUserService.loadUserByUsername(
            sampleApplicationUser1.getUsername());
        assertEquals(sampleApplicationUser1, savedUser);
    }

}
