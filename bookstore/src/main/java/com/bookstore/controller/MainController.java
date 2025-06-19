package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for handling requests to main pages
 * such as home, categories, and contact pages.
 */
@Controller
public class MainController {

    /**
     * Handles GET requests for the home page.
     *
     * @return the name of the home view template ("index")
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /**
     * Handles GET requests for the categories page.
     *
     * @return the name of the categories view template ("categories")
     */
    @GetMapping("/categories")
    public String categories() {
        return "categories";
    }

    /**
     * Handles GET requests for the contact page.
     *
     * @return the name of the contact view template ("contact")
     */
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
