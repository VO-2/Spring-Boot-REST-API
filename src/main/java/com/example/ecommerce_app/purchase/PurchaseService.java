package com.example.ecommerce_app.purchase;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app.util.Repositories;

@Service
@Transactional
public class PurchaseService {
    
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase getPurchase(Long purchaseId) {
        return Repositories.getEntityById(purchaseRepository, purchaseId);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
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
