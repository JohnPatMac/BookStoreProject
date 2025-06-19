package com.bookstore.controller;

import com.bookstore.model.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller to handle requests related to user login
 * and account deletion forms.
 */
@Controller
public class LoginController {

    /**
     * Displays the login form to the user.
     *
     * @param model the model to hold form attributes
     * @return the name of the login view template
     */
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserLogin()); 
        return "login"; 
    }

    /**
     * Displays the form for deleting a user account.
     *
     * @return the name of the delete account view template
     */
    @GetMapping("/deleteAccountForm")
    public String showDeleteAccountForm() {
        return "delete_account"; 
    }
}

