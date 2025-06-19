package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.bookstore.model.User;
import com.bookstore.repository.UserRepository;

import java.util.Collections;

/**
 * Custom implementation of {@link UserDetailsService} to load user-specific data.
 * This service is used by Spring Security during authentication to retrieve user details from the database.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    /**
     * Repository to access user data.
     */
    private final UserRepository userRepository;

    /**
     * Constructs a new CustomUserDetailsService with the given UserRepository.
     * 
     * @param userRepository the repository used to find users by username
     */
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Locates the user based on the username.
     * 
     * @param username the username identifying the user whose data is required
     * @return a fully populated {@link UserDetails} object (from Spring Security)
     * @throws UsernameNotFoundException if the user could not be found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) 
            throw new UsernameNotFoundException("User not found with username: " + username);
        
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
