package com.example.ecommerce_app.validation;

import java.sql.Blob;
import java.sql.SQLException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BlobMaxSizeValidator implements ConstraintValidator<BlobMaxSize, Blob> {

    private long maxSize;

    @Override
    public void initialize(BlobMaxSize blobMaxSize) {
        maxSize = blobMaxSize.value();
    }

    @Override
    public boolean isValid(Blob value, ConstraintValidatorContext context) {
        try {
            return value.length() <= maxSize;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
