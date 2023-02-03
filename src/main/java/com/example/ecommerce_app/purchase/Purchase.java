package com.example.ecommerce_app.purchase;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.user.ApplicationUser;

@Entity
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchase_id;

    @ManyToMany()
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private ApplicationUser purchaser;

    @NotNull
    private LocalDate purchase_date;

    public Purchase() {
    }

    public Purchase(@NotNull LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
