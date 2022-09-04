package com.example.ecommerce_app.purchase;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.user.ApplicationUser;

@Entity
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchase_id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private ApplicationUser purchaser;

    @NotNull
    private LocalDate purchase_date;

    public Purchase() {
    }

    public Purchase(Product product, ApplicationUser purchaser, @NotNull LocalDate purchase_date) {
        this.product = product;
        this.purchaser = purchaser;
        this.purchase_date = purchase_date;
    }

    public Long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ApplicationUser getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(ApplicationUser purchaser) {
        this.purchaser = purchaser;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }
    
}
