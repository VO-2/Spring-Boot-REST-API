package com.example.ecommerce_app.purchase;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.user.ApplicationUser;

@Entity
public class Purchase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long purchase_id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private ApplicationUser purchaser;

    @Column(nullable = false)
    private LocalDate purchase_date;

}
