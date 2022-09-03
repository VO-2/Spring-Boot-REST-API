package com.example.ecommerce_app.api;

public class ApiEndpoint {

    private ApiEndpointPublicity publicity;
    private ApiEndpointVersion version;
    private ApiEndpointType type;
    private String id_String;
    private String endpoint;

    public ApiEndpoint(ApiEndpointPublicity publicity, ApiEndpointVersion version, ApiEndpointType type,
            boolean requiresId) {
        this.publicity = publicity;
        this.version = version;
        this.type = type;
        this.id_String = requiresId ? String.format("{%s_id}", type.toString()) : "";
    }

    public String toUrlString() {
        String publicityString = (publicity == ApiEndpointPublicity.Private) ? 
            "" : publicity.toString().toLowerCase() + "/";
        return String.format("/%sapi/%s/%s/%s", publicityString, version.toString(), type.toString(), id_String);
    }

    public ApiEndpointPublicity getPublicity() {
        return publicity;
    }

    public void setPublicity(ApiEndpointPublicity publicity) {
        this.publicity = publicity;
    }

    public ApiEndpointVersion getVersion() {
        return version;
    }

    public void setVersion(ApiEndpointVersion version) {
        this.version = version;
    }

    public ApiEndpointType getType() {
        return type;
    }

    public void setType(ApiEndpointType type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    
}
