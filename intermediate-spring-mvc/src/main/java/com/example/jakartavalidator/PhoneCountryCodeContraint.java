package com.example.jakartavalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneCountryCodeContraint implements ConstraintValidator<CountryCode, String> {

    @Override
    public boolean isValid(String countryCode, ConstraintValidatorContext context) {
        if (!Helper.isNumericInt(countryCode))
            return false;
        if (countryCode.length() > 2)
            return false;
        return true;
    }

}
