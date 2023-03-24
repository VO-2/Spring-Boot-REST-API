package com.example.ecommerce_app.purchase;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_app.product.Product;

@RestController
@Validated
@RequestMapping("/api/purchase")
public class PurchaseController {

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("{purchaseId}")
    public Purchase getPurchase(@PathVariable(name = "purchase_id") Long purchaseId) {
        return purchaseService.getPurchase(purchaseId);
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase,
        @RequestParam(name = "user_id", required = false) Long userId,
        @RequestParam(name = "product_id") List<Long> productIds)  {
            return purchaseService.savePurchase(purchase, userId, productIds);
    }

    @PutMapping()
    public Purchase updatePurchase(@RequestBody Purchase purchase, @PathVariable Long userId, @RequestParam(name = "product_id") List<Long> productIds) {
        return purchaseService.updatePurchase(purchase, userId, productIds);
    }

    @DeleteMapping("{purchaseId}")
    public void deletePurchase(@PathVariable Long purchaseId) {
        purchaseService.deletePurchase(purchaseId);
    }
}
