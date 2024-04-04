package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.dto.Book;

@Controller
public class BookController {

    @GetMapping("/book")
    public String book(@ModelAttribute("book") Book book)// (Book book, Model model) {
    {
        // LONGER WAY TO DO THE SAME
        // Book book2 = new Book();
        // model.addAttribute("book", book);

        return "index";
    }

    @GetMapping("/book/show")
    public String show(Book book, Model model) {
        model.addAttribute("book", book);
        return "show";
    }

    @GetMapping("/book/jsp")
    public String bookJsp(@ModelAttribute("book") Book book)// (Book book, Model model) {
    {
        // LONGER WAY TO DO THE SAME
        // Book book2 = new Book();
        // model.addAttribute("book", book);

        return "jsp/index";
    }

    @GetMapping("/book/show/jsp")
    public String showJsp(Book book, Model model) {
        model.addAttribute("book", book);
        return "jsp/show";
    }
}
