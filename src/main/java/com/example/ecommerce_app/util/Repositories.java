package com.example.ecommerce_app.util;

import org.springframework.data.repository.CrudRepository;

public class Repositories {
    
    public static <T, G extends Number> T getEntityById(CrudRepository<T, G> repository, G id) {
        return repository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(
                String.format("No entity found for id '%s' in %s", id, repository.getClass().getSimpleName())
            )
        );
    }

}
