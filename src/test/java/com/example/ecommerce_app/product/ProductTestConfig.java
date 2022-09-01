package com.example.ecommerce_app.product;

import java.math.BigDecimal;
import java.util.Set;

import com.example.ecommerce_app.user.ApplicationUser;

public class ProductTestConfig {
    
    static final ApplicationUser sampleApplicationUser = new ApplicationUser(
        "username",
        "password",
        "email@email.com",
        true,
        true,
        true,
        true,
        Set.of(),
        Set.of(),
        Set.of()
    );

    static final Product testProduct = new Product(
        "name",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        null,
        sampleApplicationUser
    );

    static final Product testProductToRead = new Product(
        "name",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        null,
        sampleApplicationUser
    );

    static final Product testProductToDelete = new Product(
        100l,
        "name",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        null,
        sampleApplicationUser
    );

    static final Product testProductViolatingNameSizeConstraint = new Product(
        "",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        null,
        sampleApplicationUser
    );

    static final Product testProductViolatingNameNullConstraint = new Product(
        null,
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        null,
        sampleApplicationUser
    );

    static final long unusedProductId = 5l;

}
