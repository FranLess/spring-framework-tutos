package com.example.dto;

import com.example.jakartavalidator.ValidPhone;

// import com.example.validator.CountryCode;
// import com.example.validator.PhoneNumber;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@ValidPhone
public class Phone {
    @Getter
    @Setter
    private String countryCode;
    @Getter
    @Setter
    private String number;

    @Override
    public String toString() {
        return getCountryCode() + "-" + getNumber();
    }
}
