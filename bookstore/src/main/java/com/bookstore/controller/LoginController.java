package com.bookstore.controller;

import com.bookstore.model.UserLogin; 
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserLogin()); 
        return "login";  
    }

    
    @PostMapping("/login")
    public String handleLogin(@Valid UserLogin user, BindingResult result, Model model) {
     
        if (result.hasErrors()) {
            return "login"; 
        }

        if ("admin".equals(user.getUsername()) && "password123".equals(user.getPassword())) {
           
            return "redirect:/products"; 
        } else {
            
            model.addAttribute("loginError", "Invalid username or password");
            return "login";  
        }
    }
}
