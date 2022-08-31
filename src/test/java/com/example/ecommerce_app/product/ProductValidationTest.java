package com.example.ecommerce_app.product;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import com.example.ecommerce_app.user.ApplicationUser;

@SpringBootTest
public class ProductValidationTest {
    // Test that can't create product w/ fields out of bounds
    // Make a few product objs that test multiple constraints, then use assertAll

    private Product product;

    @BeforeEach
    void setup() {
        product = new Product(
            1l,
            "",
            0,
            true,
            BigDecimal.ONE,
            "",
            Set.of(),
            null,
            Set.of(), 
            Set.of(),
            new ApplicationUser() 
        );
    }

    // @Test
    // void productNameMinimumTest() {
    //     assertThrows(
    //         RuntimeException.class,
    //         () -> entityValidation(product)
    //     );
    // }

    
    <T> void entityValidation(T entity) {
    }
}
