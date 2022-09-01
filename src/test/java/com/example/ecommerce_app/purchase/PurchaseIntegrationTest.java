package com.example.ecommerce_app.purchase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.ecommerce_app.purchase.PurchaseTestConfig.purchase;
import static com.example.ecommerce_app.purchase.PurchaseTestConfig.unusedpurchaseId;
import static com.example.ecommerce_app.purchase.PurchaseTestConfig.purchaseToRead;
import static com.example.ecommerce_app.purchase.PurchaseTestConfig.purchaseToDelete;
import static com.example.ecommerce_app.purchase.PurchaseTestConfig.purchaseViolatingPurchaseDateNullConstraint;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PurchaseIntegrationTest {

    @Autowired
    private PurchaseController purchaseController;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @BeforeAll
    void init() {
        purchaseRepository.save(purchaseToDelete);
        purchaseRepository.save(purchaseToRead);
    }

    @Test
    void testCreatePurchase() {
        assertDoesNotThrow(() -> purchaseController.createPurchase(purchase));
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
        assertDoesNotThrow(() -> purchaseController.updatePurchase(purchaseToRead));
    }

    @Test
    void createPurchaseExceptionOnInvalidId() {
        assertThrows(
            RuntimeException.class,
            () -> purchaseController.getPurchase(unusedpurchaseId)
        );
    }

    @Test
    void createPurchaseExceptionOnNullPurchaseDate() {
        assertThrows(
            RuntimeException.class,
            () -> purchaseController.createPurchase(purchaseViolatingPurchaseDateNullConstraint)
        );
    }
}
