package com.bookstore.service;

import org.springframework.stereotype.Service;

import com.bookstore.model.UserLogin;

/**
 * Service class responsible for user authentication.
 */
@Service  
public class AuthService {

    /**
     * Authenticates a user based on username and password.
     * Currently, this method checks if the username is "admin"
     * and the password is "password123".
     *
     * @param user the UserLogin object containing user credentials
     * @return true if the credentials match the hardcoded values, false otherwise
     */
    public boolean authenticate(UserLogin user) {
        return "admin".equals(user.getUsername()) && "password123".equals(user.getPassword());
    }
}
