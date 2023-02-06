package com.example.ecommerce_app.purchase;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce_app.product.ProductRepository;

import static com.example.ecommerce_app.purchase.PurchaseTestConfig.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PurchaseIntegrationTest {

    @Autowired
    private PurchaseController purchaseController;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeAll
    void init() {
        productRepository.save(product);
        purchaseRepository.save(purchaseToDelete);
        purchaseRepository.save(purchaseToRead);
    }

    @Test
    void testCreatePurchase() {
        assertAll(
            () -> assertDoesNotThrow(() -> purchaseController.createPurchase(purchase, null, null))
        );
    }

    @Test
    void testDeletePurchase() {
        assertDoesNotThrow(() -> purchaseController.deletePurchase(purchaseToDelete.getPurchase_id()));
    }

    @Test
    void testGetAllPurchases() {
        assertDoesNotThrow(() -> purchaseController.getAllPurchases());
    }

    @Test
    void testGetPurchase() {
        assertDoesNotThrow(() -> purchaseController.getPurchase(purchaseToRead.getPurchase_id()));
    }

    @Test
    void testUpdatePurchase() {
        assertDoesNotThrow(() -> purchaseController.updatePurchase(purchaseToRead, null, null));
    }

    @Test
    void getPurchaseExceptionOnInvalidId() {
        assertThrows(
            RuntimeException.class,
            () -> purchaseController.getPurchase(unusedpurchaseId)
        );
    }

    @Test
    void createPurchaseExceptionOnNullPurchaseDate() {
        assertThrows(
            RuntimeException.class,
            () -> purchaseController.createPurchase(purchaseViolatingPurchaseDateNullConstraint, null, null)
        );
    }
}
