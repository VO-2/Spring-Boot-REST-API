package com.example.ecommerce_app.product;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Properties;
import java.util.Set;

import com.example.ecommerce_app.user.ApplicationUser;
import com.mysql.cj.exceptions.ExceptionInterceptorChain;
import com.mysql.cj.log.NullLogger;

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

    static final Blob sampleBlob = new com.mysql.cj.jdbc.Blob(new byte[] {0},
        new ExceptionInterceptorChain(null, new Properties(), new NullLogger(""))
    );

    static final Product testProduct = new Product(
        "name",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob,
        null
    );

    static final Product testProductToRead = new Product(
        "name",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob,
        null
    );

    static final Product testProductToDelete = new Product(
        "name",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob,
        null
    );

    static final Product testProductViolatingNameSizeConstraint = new Product(
        "",
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob,
        null
    );

    static final Product testProductViolatingNameNullConstraint = new Product(
        null,
        1,
        true,
        BigDecimal.ONE,
        "description",
        Set.of(),
        sampleBlob,
        null
    );

    static final long unusedProductId = 50l;

}
