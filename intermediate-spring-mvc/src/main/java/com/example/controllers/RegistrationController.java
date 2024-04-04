package com.example.controllers;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.Phone;
import com.example.dto.UserRegistrationDTO;
import com.example.property.editors.PhoneEditor;
import com.example.validator.ValidUserRegister;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String showRegistrationPage(@ModelAttribute("user") UserRegistrationDTO user) {
        return "registration-page";
    }

    @GetMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserRegistrationDTO user, BindingResult result) {
        if (result.hasErrors())
            return "registration-page";
        return "register-page";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // binder.addValidators(new ValidUserRegister());
        binder.registerCustomEditor(Phone.class, new PhoneEditor());
        // StringTrimmerEditor
    }
}
