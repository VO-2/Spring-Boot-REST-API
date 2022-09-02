package com.example.ecommerce_app.purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.user.ApplicationUser;

public class PurchaseTestConfig {

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

    static final Purchase purchase = new Purchase(
        null,
        null,
        LocalDate.now()
    );

    static final Purchase purchaseToRead = new Purchase(
        null,
        null,
        LocalDate.now()
    );

    static final Purchase purchaseToDelete = new Purchase(
        null,
        null,
        LocalDate.now()
    );

    static final Purchase purchaseViolatingPurchaseDateNullConstraint = new Purchase(
        null,
        null,
        null
    );

    static final long unusedpurchaseId = 50l;
}
