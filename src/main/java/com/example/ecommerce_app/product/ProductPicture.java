package com.example.ecommerce_app.product;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.ecommerce_app.validation.BlobMaxSize;

@Entity
public class ProductPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long picture_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    @BlobMaxSize(Product.MAX_IMAGE_SIZE)
    private Blob blob;

    public ProductPicture() {
    }

    public ProductPicture(Long picture_id, Product product, Blob blob) {
        this.picture_id = picture_id;
        this.product = product;
        this.blob = blob;
    }

    public Long getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Long picture_id) {
        this.picture_id = picture_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    
}
