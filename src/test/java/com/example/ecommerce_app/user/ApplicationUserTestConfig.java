package com.example.ecommerce_app.user;

import java.util.Set;

public class ApplicationUserTestConfig {

    static final ApplicationUser testApplicationUser_ToCreate = new ApplicationUser(
        "password",
        "email1@email.com",
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ToRead = new ApplicationUser(
        "password",
        "email2@email.com",
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ToDelete = new ApplicationUser(
        "password",
        "email3@email.com",
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ViolatingEmailFormat = new ApplicationUser(
        "password",
        "e",
        Set.of(),
        Set.of()
    );

}
