package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.model.User;
import com.bookstore.model.UserLogin;
import com.bookstore.model.UserRegister;
import com.bookstore.service.LoginService;
import com.bookstore.service.UserService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	@Autowired
	private UserRegister userRegister;
	@Autowired
	private UserService userService;
	@Autowired
    private LoginService loginService;  
	
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
	
	/*
	 * Putting update functions here for now since all fields are dealt with in updating the account
	 * RegisterController and LoginController should likely be merged into an AccountController in a future assignment
	 */
	@GetMapping("/updateAccess")
	public String loginToUpdate(Model model) {
		model.addAttribute("updateUserLogin", new UserLogin());
		return "update_access";
	}
	
	@PostMapping("/updateAccess")
	public String showUpdateForm(
            		@Valid @ModelAttribute("updateUserLogin") UserLogin updateUserLogin,
            		BindingResult result,
            		Model model) {
		if (result.hasErrors()) {
        	return "update_access";
		}
		if (!loginService.login(updateUserLogin)) {
			model.addAttribute("loginError", "Invalid username or password");
			return "update_access";
		}
		
		model.addAttribute("updateUser", userService.findByUsername(updateUserLogin.getUsername()));
		return "update_account";
	}
	
	@PostMapping("/updateAccount")
	public String updateUser(
			@Valid @ModelAttribute("updateUserLogin") User user,
    		BindingResult result,
    		Model model) {
		
		model.addAttribute("updateUser", user);
		
		if (result.hasErrors()) {
        	return "update_account";
		}
		
		// redirect to home if there's no errors
		try {
			userService.saveUser(user);
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("updateError", e.getMessage());
        }
		
		return "update_account";
	}
}
