package com.example.ecommerce_app.api;

public enum ApiEndpointType {
    Product,
    Purchase;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
