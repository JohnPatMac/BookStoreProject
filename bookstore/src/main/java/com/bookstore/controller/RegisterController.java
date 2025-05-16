package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.model.UserRegister;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
	@Autowired
	private UserRegister userRegister;

	@GetMapping("/register")
    public String showLoginForm(Model model) {
        model.addAttribute("newUser", userRegister);
        return "register";
    }
	
	@PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("newUser") UserRegister user, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("registerError", "Invalid entry");
            return "register";
        } else {
        	return "redirect:/products";
        }
	}
}
