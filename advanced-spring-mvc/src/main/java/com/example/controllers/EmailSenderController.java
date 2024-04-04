package com.example.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.dto.UserDTO;
import com.example.services.EmailSenderService;

@Controller
public class EmailSenderController {
    @Autowired
    private EmailSenderService emailSenderService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/email/send")
    public String sendEmail(@SessionAttribute("user") UserDTO user, @RequestParam("email") String email, Model model) {
        user.setEmail(email);
        try {
            emailSenderService.sendEmail(user.getEmail(),
                    "LOVE CALCULATOR",
                    user.getName() + " AND " + user.getCrushName() + " YOU ARE FRIEND");
        } catch (Exception e) {
            logger.warning("Email not sent correctly" + e.getMessage());
            return "email/fail";
        }
        return "email/success";
    }

    @GetMapping("/")
    @ResponseBody
    public String a() {
        return "Pinche morro hay que jugar";
    }
}
