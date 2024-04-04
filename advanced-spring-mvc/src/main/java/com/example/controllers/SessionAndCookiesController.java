package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.dto.UserDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({ "user" })
public class SessionAndCookiesController {

    // SETTING NAME COOKIE METHODS
    @GetMapping("/cookie/form")
    public String getDataForCookie(Model model) {
        model.addAttribute("user", new UserDTO());
        return "cookie/form";
    }

    @GetMapping("/cookie/success")
    public String settingCookie(UserDTO user, HttpServletResponse response) {
        Cookie nameCookie = new Cookie("app.userName", user.getName());
        nameCookie.setMaxAge(60 * 30);
        response.addCookie(nameCookie);
        return "cookie/success";
    }

    @GetMapping("/cookie/show")
    public String showCoookie(Model model, HttpServletRequest request) {
        String theCookie = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("app.userName"))
                theCookie = cookie.getValue();
        }
        model.addAttribute("userName", theCookie);
        return "cookie/show";

    }

    // SETTING SESSION MANUALLY
    @GetMapping("/session/form")
    public String getDataForSession(HttpSession session, Model model) {
        session.setMaxInactiveInterval(60 * 60);
        model.addAttribute("user", new UserDTO());
        return "session/form";
    }

    @GetMapping("/session/success")
    public String successSession(UserDTO user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", user.getName());
        return "session/success";
    }

    @GetMapping("/session/show")
    public String showSession(HttpServletRequest request) {
        return "session/show";
    }

    // SETTING SESSION WITH @SessionAttribute annotation
    @GetMapping("/session/annotated/form")
    public String getDataForSessionWithAnnotation(Model model) {
        model.addAttribute("user", new UserDTO());
        return "session/annotated/form";
    }

    @GetMapping("/session/annotated/success")
    public String successSessionAnnotated(UserDTO user, Model model) {
        model.addAttribute("user", user);
        return "session/annotated/success";
    }

    // request here isn't needed, it is just for debuggin
    @GetMapping("/session/annotated/show")
    public String showSessionAnnotated(Model model, HttpServletRequest request) {
        return "session/annotated/show";
    }

    // @GetMapping("/session/attribute")
    // public String showSessionAttribute(@SessionAttribute("user.name") String
    // userName, Model model) {
    // userName = userName + " This is a modified session attribute passed through
    // model";
    // model.addAttribute("userName", userName);
    // return "session/attribute/show";
    // }

    @InitBinder
    public void initBinder() {

    }
}
