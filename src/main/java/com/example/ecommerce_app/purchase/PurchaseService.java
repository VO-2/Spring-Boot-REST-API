package com.example.ecommerce_app.purchase;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.product.ProductRepository;
import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class PurchaseService {
    
    private PurchaseRepository purchaseRepository;

    private ProductRepository productRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
    }

    public Purchase getPurchase(Long purchaseId) {
        return Repositories.getEntityById(purchaseRepository, purchaseId);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    
    public Purchase makePurchase(Purchase purchase) {

        List<Product> products = purchase.getProducts();

        // Throw exception if there's a product that isn't for sale
        products.forEach((product) -> {
                if (!product.isFor_sale()) {
                    throw new IllegalStateException(String.format("Product '%s' is not for sale", product.getName()));
                }
            }
        );

        return purchaseRepository.save(purchase);
    }

    public Purchase savePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }

    public void deletePurchase(Purchase purchase) {
        purchaseRepository.delete(purchase);
    }
}
