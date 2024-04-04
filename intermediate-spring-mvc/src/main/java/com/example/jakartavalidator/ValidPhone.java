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
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Constraint(validatedBy = ConstraintValidPhone.class)
public @interface ValidPhone {

    String message() default "{phone.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
