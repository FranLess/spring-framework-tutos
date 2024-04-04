package com.example.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.example.dto.Phone;

public class PhoneFormatter implements Formatter<Phone> {

    @Override
    public String print(Phone phone, Locale locale) {
        return phone.toString();
    }

    @Override
    public Phone parse(String text, Locale locale) throws ParseException {
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
