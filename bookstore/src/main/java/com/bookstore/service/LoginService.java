package com.bookstore.service;

import com.bookstore.model.User;
import com.bookstore.model.UserLogin;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(UserLogin loginData) {
        User user = userRepository.findByUsername(loginData.getUsername());
        return user != null && user.getPassword().equals(loginData.getPassword());
    }
    
    public boolean deleteAccount(String username) {
	    User user = userRepository.findByUsername(username);
	    if (user != null) {
	        userRepository.deleteByUsername(username);
	        return true;
	    }
	    return false;
	}
    
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
