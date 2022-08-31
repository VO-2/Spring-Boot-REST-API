package com.example.ecommerce_app.user;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationUserServiceTest {
    
    @Autowired
    private ApplicationUserService applicationUserService;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    private ApplicationUser sampleApplicationUser1 = new ApplicationUser(
        "username",
        "password",
        "email@email.com",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of(),
        Set.of()
    );
    
    @BeforeAll
    void init() {
         applicationUserRepository.deleteAll();
         applicationUserRepository.save(sampleApplicationUser1);
     }

    @Test
    void contextLoads() {
        assertAll(
            () -> assertNotNull(applicationUserService),
            () -> assertNotNull(applicationUserRepository)
        );
    }

    @Test
    void loadUserByUsername_EmptyDB() {
        assertThrows(UsernameNotFoundException.class, () -> {
            applicationUserService.loadUserByUsername("");
        });
    }

    @Test
    void loadUserByUsername() {
        ApplicationUser savedUser = applicationUserService.loadUserByUsername(sampleApplicationUser1.getUsername());
        assertNotNull(savedUser);
    }

}
