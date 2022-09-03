package com.example.ecommerce_app.api;

public enum ApiEndpointVersion {
    V1;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
