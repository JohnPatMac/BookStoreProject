package com.bookstore.controller;

import com.bookstore.model.UserLogin;
import com.bookstore.service.LoginService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;  

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserLogin());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@Valid @ModelAttribute("user") UserLogin user,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        if (loginService.login(user)) {
            return "redirect:/products/new";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }
    }
}
