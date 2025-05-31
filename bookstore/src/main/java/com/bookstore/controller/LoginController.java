package com.bookstore.controller;

import com.bookstore.model.User;
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
import org.springframework.web.bind.annotation.RequestParam;

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
    
 // Show the delete account form
    @GetMapping("/deleteAccountForm")
    public String showDeleteAccountForm() {
        return "delete_account";
    }

    // Handle account deletion
    @PostMapping("/deleteAccount")
    public String deleteAccount(@RequestParam String username,
                                @RequestParam String password,
                                Model model) {
        User user = loginService.findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            loginService.deleteUser(user);
            model.addAttribute("deleteMessage", "Account successfully deleted.");
        } else {
            model.addAttribute("deleteMessage", "Invalid username or password.");
        }

        // Redirect back to login page
        model.addAttribute("user", new UserLogin());
        return "login";
    }
}
