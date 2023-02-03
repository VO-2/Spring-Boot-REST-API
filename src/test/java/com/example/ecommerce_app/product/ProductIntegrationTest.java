package com.example.ecommerce_app.product;

import static com.example.ecommerce_app.product.ProductTestConfig.testProduct;
import static com.example.ecommerce_app.product.ProductTestConfig.testProductToDelete;
import static com.example.ecommerce_app.product.ProductTestConfig.testProductToRead;
import static com.example.ecommerce_app.product.ProductTestConfig.testProductViolatingNameNullConstraint;
import static com.example.ecommerce_app.product.ProductTestConfig.testProductViolatingNameSizeConstraint;
import static com.example.ecommerce_app.product.ProductTestConfig.unusedProductId;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductIntegrationTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductRepository productRepository;

    @BeforeAll
    void init() {
        productRepository.save(testProductToDelete);
        productRepository.save(testProductToRead);
    }

    @Test
    void testCreateProduct() {
        assertDoesNotThrow(() -> productController.createProduct(testProduct, null));
    }

    @Test
    void testDeleteProduct() {
        assertDoesNotThrow(() -> productController.deleteProduct(testProductToDelete.getProduct_id()));
    }

    @Test
    void testGetAllProducts() {
        assertDoesNotThrow(() -> productController.getAllProducts());
    }

    @Test
    void testGetProduct() {
        assertDoesNotThrow(() -> productController.getProduct(testProductToRead.getProduct_id()));
    }

    @Test
    void testUpdateProduct() {
        assertDoesNotThrow(() -> productController.updateProduct(testProductToRead, null));
    }

    @Test
    void getProductExceptionOnInvalidId() {
        assertThrows(
            RuntimeException.class,
            () -> productController.getProduct(unusedProductId)
        );
    }

    @Test
    void createProductExceptionOnInvalidNameLength() {
        assertThrows(
            RuntimeException.class,
            () -> productController.createProduct(testProductViolatingNameSizeConstraint, null)
        );
    }
    
    @Test
    void createProductExceptionOnNullName() {
        assertThrows(
            RuntimeException.class,
            () -> productController.createProduct(testProductViolatingNameNullConstraint, null)
        );
    }

}
