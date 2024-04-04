package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.dto.Phone;
import com.example.dto.UserRegistrationDTO;

public class ValidUserRegister implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegistrationDTO user = (UserRegistrationDTO) target;
        String email = user.getContact().getEmail();
        Phone phone = user.getContact().getPhone();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.email", "email.empty");
        if (!isValid(phone))
            errors.rejectValue("contact.phone", "phone.invalid");

    }

    public boolean isValid(Phone phone) {
        if (phone == null)
            return false;
        if (!(phone.getCountryCode().length() == 2))
            return false;
        if (!(phone.getNumber().length() == 10))
            return false;
        return true;
    }
}
