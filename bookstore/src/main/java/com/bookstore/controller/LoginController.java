package com.bookstore.controller;

import com.bookstore.model.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserLogin()); 
        return "login"; 
    }

    @GetMapping("/deleteAccountForm")
    public String showDeleteAccountForm() {
        return "delete_account"; 
    }
}

