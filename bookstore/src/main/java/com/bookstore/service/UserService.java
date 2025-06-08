package com.bookstore.service;

import com.bookstore.model.User;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
       
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}

