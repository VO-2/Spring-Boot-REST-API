package com.example.ecommerce_app.api;

public enum ApiEndpointPublicity {
    Public,
    Private;
    
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
