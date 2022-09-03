package com.example.ecommerce_app.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.example.ecommerce_app.api.ApiEndpointTestConfig.*;

import org.junit.jupiter.api.Test;

public class ApiEndpointTest {

    @Test
    void testToUrlString_PublicPublicity() {
        assertEquals(publicApiEndpointExpectedUrl, publicApiEndpoint.toUrlString());
    }

    @Test
    void testToUrlString_PrivatePublicity() {
        assertEquals(privateApiEndpointExpectedUrl, privateApiEndpoint.toUrlString());
    }

    @Test
    void testToUrlString_RequiresId() {
        assertEquals(ApiEndpointRequiringIdExpectedUrl, apiEndpointRequiringId.toUrlString());
    }
}
