package com.example.controllers;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hi")
    public String hello() {
        return "COLACAOASLD";
    }

    @GetMapping("/home")
    public String home() {
        return "Home page";
    }
}
