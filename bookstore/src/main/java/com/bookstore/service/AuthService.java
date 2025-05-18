package com.bookstore.service;

import com.bookstore.model.UserLogin;
import org.springframework.stereotype.Service;

@Service  
public class AuthService {

    public boolean authenticate(UserLogin user) {
        
        return "admin".equals(user.getUsername()) && "password123".equals(user.getPassword());
    }
}
