package com.example.ecommerce_app.product.review;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.example.ecommerce_app.product.Product;
import com.example.ecommerce_app.user.ApplicationUser;

@Entity
public class ProductReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long review_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser reviewer;

    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String text;

    @Min(0) 
    @Max(5)
    @Column(nullable = false)
    private short rating;

    public ProductReview() {
    }

    public ProductReview(Long review_id, Product product, ApplicationUser reviewer, String text, short rating) {
        this.review_id = review_id;
        this.product = product;
        this.reviewer = reviewer;
        this.text = text;
        this.rating = rating;
    }

    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ApplicationUser getAuthor() {
        return reviewer;
    }

    public void setAuthor(ApplicationUser reviewer) {
        this.reviewer = reviewer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

}
