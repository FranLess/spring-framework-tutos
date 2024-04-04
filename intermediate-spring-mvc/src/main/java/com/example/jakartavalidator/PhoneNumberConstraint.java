package com.example.jakartavalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberConstraint implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (!Helper.isNumericInt(phoneNumber))
            return false;
        if (phoneNumber.length() > 10)
            return false;
        return true;
    }

}