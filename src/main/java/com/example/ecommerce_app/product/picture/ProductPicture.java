package com.example.ecommerce_app.product.picture;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.ecommerce_app.product.Product;
import static com.example.ecommerce_app.product.Product.MAX_IMAGE_SIZE;
import com.example.ecommerce_app.validation.BlobMaxSize;

@Entity
public class ProductPicture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long pictureId;

    @BlobMaxSize(MAX_IMAGE_SIZE)
    @Column(nullable = false)
    private Blob picture;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductPicture() {
    }

    public ProductPicture(Long pictureId, @BlobMaxSize(2097152) Blob picture, Product product) {
        this.pictureId = pictureId;
        this.picture = picture;
        this.product = product;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
