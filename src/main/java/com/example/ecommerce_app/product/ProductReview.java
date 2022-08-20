package com.example.ecommerce_app.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private ApplicationUser author;

    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String text;

    public ProductReview() {
    }

    public ProductReview(Long review_id, Product product, ApplicationUser author, String text) {
        this.review_id = review_id;
        this.product = product;
        this.author = author;
        this.text = text;
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
        return author;
    }

    public void setAuthor(ApplicationUser author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    

}
