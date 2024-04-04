package com.example.jakartavalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneCountryCodeContraint.class)
public @interface PhoneNumber {
    String message() default "Phone number must be 10 digit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
