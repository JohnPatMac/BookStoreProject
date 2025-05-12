package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "index"; 
    }

    @GetMapping("/books")
    public String books() {
        return "books"; 
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart"; 
    }
    
    @GetMapping("/categories")
    public String categories() {
        return "categories"; 
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; 
    }

}



