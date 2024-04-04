package com.example.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.example.dto.Phone;

public class PhoneConverter implements Converter<String, Phone> {

    @Override
    @Nullable
    public Phone convert(String text) {
        String[] number = { text };

        Phone phone = new Phone();
        if (text.contains("-"))
            number = text.split("-");
        if (number.length == 1)
            number = new String[] { "52", text };
        phone.setCountryCode(number[0]);
        phone.setNumber(number[1]);
        return phone;
    }

}
