package com.bookstore.controller;

import com.bookstore.model.User;
import com.bookstore.model.UserLogin;
import com.bookstore.model.UserRegister;
import com.bookstore.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserRegister userRegister;

    @Autowired
    private UserService userService;

    public RegisterController(UserRegister userRegister, UserService userService) {
        this.userRegister = userRegister;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("newUser", userRegister);
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("newUser") UserRegister user,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("registerError", "Invalid entry");
            return "register";
        }

        try {
            User newUser = new User(
                user.getUsername(),
                user.getPassword(), 
                user.getEmail(),
                user.getPhoneNumber()
            );
            userService.saveUser(newUser);
        } catch (Exception e) {
            model.addAttribute("registerError", e.getMessage());
            return "register";
        }

        return "redirect:/login"; 
    }

    @GetMapping("/updateAccess")
    public String loginToUpdate(Model model) {
        model.addAttribute("updateUserLogin", new UserLogin());
        return "update_access";
    }

    @PostMapping("/updateAccess")
    public String showUpdateForm(@Valid @ModelAttribute("updateUserLogin") UserLogin updateUserLogin,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            return "update_access";
        }

        User user = userService.findByUsername(updateUserLogin.getUsername());
        if (user == null) {
            model.addAttribute("loginError", "User not found");
            return "update_access";
        }

        model.addAttribute("updateUser", user);
        return "update_account";
    }

    @PostMapping("/updateAccount")
    public String updateUser(@Valid @ModelAttribute("updateUserLogin") User user,
                             BindingResult result,
                             Model model) {
        model.addAttribute("updateUser", user);

        if (result.hasErrors()) {
            return "update_account";
        }

        try {
            userService.saveUser(user);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("updateError", e.getMessage());
            return "update_account";
        }
    }
}
