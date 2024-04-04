package com.example.jakartavalidator;

public class Helper {
    public static boolean isNumericInt(String str) {
        return str != null && str.matches("^[0-9]\\d*$");
    }
}
