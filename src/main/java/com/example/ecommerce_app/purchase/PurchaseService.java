package com.example.ecommerce_app.purchase;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.product.ProductRepository;
import com.example.ecommerce_app.user.ApplicationUserRepository;
import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class PurchaseService {

    private PurchaseRepository purchaseRepository;
    private ApplicationUserRepository applicationUserRepository;
    private ProductRepository productRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, ApplicationUserRepository applicationUserRepository,
            ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.productRepository = productRepository;
    }

    public Purchase getPurchase(Long purchaseId) {
        return Repositories.getEntityById(purchaseRepository, purchaseId);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase savePurchase(Long userId, List<Long> productIds) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }

        Purchase purchase = new Purchase(LocalDate.now());

        purchase.setPurchaser(Repositories.getEntityById(applicationUserRepository, userId));
        purchase.setProducts(mapIdsToProductList(productIds));
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase, Long userId, List<Long> productIds) {
        if (purchaseRepository.existsById(purchase.getPurchase_id())) {

            if (userId != null) {
                purchase.setPurchaser(Repositories.getEntityById(applicationUserRepository, userId));
            }

            purchase.setProducts(mapIdsToProductList(productIds));
            return purchaseRepository.save(purchase);
        }
        else {
            throw new IllegalStateException("Purcahse with purchaseId '" + purchase.getPurchase_id() + "' does not exist");
        }
    }

    public void deletePurchase(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }

    public void deletePurchase(Purchase purchase) {
        purchaseRepository.delete(purchase);
    }

    private List<Product> mapIdsToProductList(List<Long> productIds) {
        List<Product> products = null;

        if (productIds != null) {
            // Convert list of productIds to a list of Products
            products = productIds.stream()
                    .map((productId) -> (Product) Repositories.getEntityById(productRepository, productId))
                    .collect(Collectors.toList());

            // Throw exception if there's a product that isn't for sale
            products.forEach((product) -> {
                if (!product.isFor_sale()) {
                    throw new IllegalStateException(String.format("Product '%s' is not for sale", product.getName()));
                }
            });
        }
        
        return products;
    }
}
