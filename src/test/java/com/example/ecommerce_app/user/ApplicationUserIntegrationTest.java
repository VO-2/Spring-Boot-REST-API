package com.example.ecommerce_app.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.example.ecommerce_app.user.ApplicationUserTestConfig.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationUserIntegrationTest {

    @Autowired
    private ApplicationUserController applicationUserController;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @BeforeAll
    void init() {
        applicationUserRepository.save(testApplicationUser_ToDelete);
        applicationUserRepository.save(testApplicationUser_ToRead);
    }

    @Test
    void testCreateApplicationUser() {
        assertDoesNotThrow(() -> applicationUserController.createApplicationUser(testApplicationUser_ToCreate));
    }

    @Test
    void testDeleteApplicationUser() {
        assertDoesNotThrow(() -> applicationUserController.deleteApplicationUser(testApplicationUser_ToDelete.getId()));
    }

    @Test
    void testGetAllApplicationUsers() {
        assertDoesNotThrow(() -> applicationUserController.getAllApplicationUsers());
    }

    @Test
    void testGetApplicationUser() {
        assertDoesNotThrow(() -> applicationUserController.getApplicationUser(testApplicationUser_ToRead.getId()));
    }

    @Test
    void testUpdateApplicationUser() {
        assertDoesNotThrow(() -> applicationUserController.updateApplicationUser(testApplicationUser_ToRead));
    }

    @Test
    void getApplicationUserInvalidNameSize() {
        assertThrows(
            RuntimeException.class,
            () -> applicationUserController.createApplicationUser(testApplicationUser_ViolatingNameSizeConstraint)
        );
    }

    @Test
    void getApplicationUserInvalidEmailFormat() {
        assertThrows(
            RuntimeException.class,
            () -> applicationUserController.createApplicationUser(testApplicationUser_ViolatingEmailFormat)
        );
    }

}
