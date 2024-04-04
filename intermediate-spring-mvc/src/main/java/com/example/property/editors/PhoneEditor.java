package com.example.property.editors;

import java.beans.PropertyEditorSupport;

import com.example.dto.Phone;

public class PhoneEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return "asdf";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] number = { text };
        Phone phone = new Phone();
        if (text.contains("-"))
            number = text.split("-");
        if (number.length == 1)
            number = new String[] { "52", text };
        phone.setCountryCode(number[0]);
        phone.setNumber(number[1]);
        setValue(phone);
    }

}
