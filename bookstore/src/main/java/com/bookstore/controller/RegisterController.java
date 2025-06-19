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

/**
 * Controller responsible for handling user registration,
 * login for account update, and updating user account details.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserRegister userRegister;

    @Autowired
    private UserService userService;

    /**
     * Constructor to initialize the RegisterController with dependencies.
     * 
     * @param userRegister prototype model for registration form
     * @param userService service to manage user data
     */
    public RegisterController(UserRegister userRegister, UserService userService) {
        this.userRegister = userRegister;
        this.userService = userService;
    }

    /**
     * Displays the registration form.
     *
     * @param model the model to add attributes for the form
     * @return the view name for the registration page
     */
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("newUser", userRegister);
        return "register";
    }

    /**
     * Processes registration form submissions.
     * Validates input and creates a new user.
     *
     * @param user the user registration data submitted
     * @param result the binding result for validation errors
     * @param model the model to hold view attributes
     * @return redirect to login page on success, or registration form on failure
     */
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

    /**
     * Displays the login form for accessing account update.
     *
     * @param model the model to add attributes for the form
     * @return the view name for login before update
     */
    @GetMapping("/updateAccess")
    public String loginToUpdate(Model model) {
        model.addAttribute("updateUserLogin", new UserLogin());
        return "update_access";
    }

    /**
     * Processes login form submission for updating user info.
     * Validates credentials and loads user for update.
     *
     * @param updateUserLogin the user login data submitted
     * @param result the binding result for validation errors
     * @param model the model to hold view attributes
     * @return the update form view if successful, or login form on failure
     */
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

    /**
     * Processes the user account update form.
     * Validates and saves updated user information.
     *
     * @param user the updated user data submitted
     * @param result the binding result for validation errors
     * @param model the model to hold view attributes
     * @return redirect to home on success, or update form on failure
     */
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
