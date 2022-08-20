package com.example.ecommerce_app.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.example.ecommerce_app.user.ApplicationUser;

@Entity
public class ProductRating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rating_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser rater;
    
    @Min(0) 
    @Max(5)
    @Column(nullable = false)
    private short rating;

    public ProductRating() {
    }

    public ProductRating(Long rating_id, Product product, ApplicationUser rater, short rating) {
        this.rating_id = rating_id;
        this.product = product;
        this.rater = rater;
        this.rating = rating;
    }

    public Long getRating_id() {
        return rating_id;
    }

    public void setRating_id(Long rating_id) {
        this.rating_id = rating_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ApplicationUser getRater() {
        return rater;
    }

    public void setRater(ApplicationUser rater) {
        this.rater = rater;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

}
