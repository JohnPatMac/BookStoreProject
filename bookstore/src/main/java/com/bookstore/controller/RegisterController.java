package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.model.User;
import com.bookstore.model.UserRegister;
import com.bookstore.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	@Autowired
	private UserRegister userRegister;
	@Autowired
	private UserService userService;
	
	public RegisterController(UserRegister userRegister, UserService userService) {
		super();
		this.userRegister = userRegister;
		this.userService = userService;
	}

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
        }
        
        try {
        	userService.saveUser(new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber()));
        } catch (Exception e) {
        	model.addAttribute("registerError", e.getMessage());
        	return "register";
        }
        
        return "redirect:/";
	}
}
