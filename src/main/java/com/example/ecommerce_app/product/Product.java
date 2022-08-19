package com.example.ecommerce_app.product;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.example.ecommerce_app.user.ApplicationUser;
import com.example.ecommerce_app.validation.BlobMaxSize;

@Entity
@Table(name = "product")
public class Product {
    
    // 2 megabytes
    private final long MAX_IMAGE_SIZE = 2097152;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;

    @Column(
        columnDefinition = "VARCHAR(200)",
        nullable = false
    )
    private String name;

    @Min(value = 0)
    @Column(
        nullable = false
    )
    private int stock;

    @Column(
        nullable = false
    )
    private boolean for_sale;

    @Min(value = 0)
    @Column(
        nullable = false
        // columnDefinition = "DECIMAL(7, 2)"
    )
    private BigDecimal price;

    @Column(
        columnDefinition = "VARCHAR(1500)"
    )
    private String description;

    @ElementCollection
    @Column(
        nullable = false
    )
    private Set<Category> categories;

    @Column(
        nullable = false
    )
    @BlobMaxSize(MAX_IMAGE_SIZE)
    private Blob thumbnail;

    @OneToMany(mappedBy = "product")
    private Set<@BlobMaxSize(MAX_IMAGE_SIZE) Blob> pictures;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private ApplicationUser owner;

    public Product() {
    }

    public Product(Long product_id, String name, int stock, boolean for_sale, BigDecimal price,
            String description, Set<Category> categories, Blob thumbnail,
            Set<Blob> pictures, ApplicationUser owner) {
        this.product_id = product_id;
        this.name = name;
        this.stock = stock;
        this.for_sale = for_sale;
        this.price = price;
        this.description = description;
        this.categories = categories;
        this.thumbnail = thumbnail;
        this.pictures = pictures;
        this.owner = owner;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isFor_sale() {
        return for_sale;
    }

    public void setFor_sale(boolean for_sale) {
        this.for_sale = for_sale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Blob getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Blob thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Set<Blob> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Blob> pictures) {
        this.pictures = pictures;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public void setOwner(ApplicationUser owner) {
        this.owner = owner;
    }
    
}
