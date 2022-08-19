package com.example.ecommerce_app.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE_USE})
@Constraint(validatedBy = BlobMaxSizeValidator.class)
public @interface BlobMaxSize {

    String message() default "Blob exceeds max size";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    long value();
    
}
