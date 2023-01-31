package com.example.ecommerce_app.user;

import java.util.Set;

public class ApplicationUserTestConfig {

    static final ApplicationUser testApplicationUser_ToCreate = new ApplicationUser(
        "username1",
        "password",
        "email1@email.com",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ToRead = new ApplicationUser(
        "username2",
        "password",
        "email2@email.com",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ToDelete = new ApplicationUser(
        "username3",
        "password",
        "email3@email.com",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ViolatingNameSizeConstraint = new ApplicationUser(
        "u",
        "password",
        "email4@email.com",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of()
    );

    static final ApplicationUser testApplicationUser_ViolatingEmailFormat = new ApplicationUser(
        "username5",
        "password",
        "e",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of()
    );

}
