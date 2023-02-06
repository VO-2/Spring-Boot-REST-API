package com.example.ecommerce_app.purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.example.ecommerce_app.product.Product;
import com.mysql.cj.exceptions.ExceptionInterceptorChain;
import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.log.NullLogger;

public class PurchaseTestConfig {

    static final Blob sampleBlob = new com.mysql.cj.jdbc.Blob(new byte[] {0},
        new ExceptionInterceptorChain(null, new Properties(), new NullLogger(""))
    );

    static final Product product = new Product(
        "name",
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob
    );

    static final Purchase purchase = new Purchase(
        LocalDate.now()
    );

    static final Purchase purchaseToRead = new Purchase(
        LocalDate.now()
    );

    static final Purchase purchaseToDelete = new Purchase(
        LocalDate.now()
    );

    static final Purchase purchaseViolatingPurchaseDateNullConstraint = new Purchase(
        null
    );

    static final long unusedpurchaseId = 50l;
}
