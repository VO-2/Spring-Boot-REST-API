package com.example.ecommerce_app.purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Set;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.user.ApplicationUser;
import com.mysql.cj.exceptions.ExceptionInterceptorChain;
import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.log.NullLogger;

public class PurchaseTestConfig {

    static final int productStartingStock = 1;

    static final Blob sampleBlob = new com.mysql.cj.jdbc.Blob(new byte[] {0},
        new ExceptionInterceptorChain(null, new Properties(), new NullLogger(""))
    );

    static final Product product = new Product(
        "name",
        productStartingStock,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob,
        null
    );

    static final Purchase purchase = new Purchase(
        product,
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
