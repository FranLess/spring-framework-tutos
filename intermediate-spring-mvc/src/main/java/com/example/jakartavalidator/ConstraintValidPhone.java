package com.example.jakartavalidator;

import com.example.dto.Phone;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConstraintValidPhone implements ConstraintValidator<ValidPhone, Phone> {

    @Override
    public boolean isValid(Phone phone, ConstraintValidatorContext context) {
        if (!(phone.getCountryCode().length() == 2))
            return false;
        if (!(phone.getNumber().length() == 10))
            return false;
        return false;
    }
}