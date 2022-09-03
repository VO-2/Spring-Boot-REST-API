package com.example.ecommerce_app.api;

public class ApiEndpointTestConfig {

    static final ApiEndpoint publicApiEndpoint = new ApiEndpoint(
        ApiEndpointPublicity.Public,
        ApiEndpointVersion.V1,
        ApiEndpointType.Product,
        false
    );

    static final ApiEndpoint privateApiEndpoint = new ApiEndpoint(
        ApiEndpointPublicity.Private,
        ApiEndpointVersion.V1,
        ApiEndpointType.Purchase,
        false
    );

    static final ApiEndpoint apiEndpointRequiringId = new ApiEndpoint(
        ApiEndpointPublicity.Private,
        ApiEndpointVersion.V1,
        ApiEndpointType.Product,
        true
    );

    static final String publicApiEndpointExpectedUrl = "/public/api/v1/product/";
    static final String privateApiEndpointExpectedUrl = "/api/v1/purchase/";
    static final String ApiEndpointRequiringIdExpectedUrl = "/api/v1/product/{product_id}";

}
