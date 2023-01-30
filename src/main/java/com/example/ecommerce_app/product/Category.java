package com.example.ecommerce_app.product;

public enum Category {
    CLOTHES ("Clothing, Shoes, Jewelry & Watches"),
    BOOKS ("Books"),
    MEDIA ("Movies, Music & Games"),
    ELECTRONICS ("Electronics"),
    COMPUTERS ("Computers"),
    SMART_HOME ("Smart Home"),
    HOUSE_SUPPLIES ("Home, Garden & Tools"),
    PET_SUPPLIES ("Pet Supplies"),
    FOOD ("Food & Grocery"),
    BEAUTY_HEALTH ("Beauty & Health"),
    TOYS ("Toys, Kids & Baby"),
    HANDMANDE ("Handmade"),
    SPORTS ("Sports"),
    OUTDOORS ("Outdoors"),
    AUTOMOTIVE ("Automotive & Industrial"),
    SCIENTIFIC ("Industrial and Scientific");

    private final String title;

    Category(String title) {
        this.title=title;
    }

    String title() {
        return this.title;
    }
}
