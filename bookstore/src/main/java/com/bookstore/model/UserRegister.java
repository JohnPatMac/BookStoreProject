package com.bookstore.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Represents a user registration model containing
 * user credentials and contact information.
 * This class is used to transfer user registration data
 * with validation constraints on each field.
 */
public class UserRegister {

    /**
     * The username of the user.
     * Must not be empty and must be between 3 and 50 characters.
     */
    @NotEmpty(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters") 
    private String username;

    /**
     * The password of the user.
     * Must not be empty and must be at least 6 characters long.
     */
    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long") 
    private String password;

    /**
     * The email address of the user.
     * Must be a valid email format.
     */
    @Email(message = "Email is required")
    private String email;

    /**
     * The phone number of the user.
     * Must not be empty and must be between 4 and 20 characters.
     */
    @NotEmpty(message = "Phone number is required")
    @Size(min = 4, max = 20, message = "Phone number must be between 4 and 20 characters")
    private String phoneNumber;

    /**
     * Gets the username.
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets the email address.
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * @param email the email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     * @return the phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     * @param phoneNumber the phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
