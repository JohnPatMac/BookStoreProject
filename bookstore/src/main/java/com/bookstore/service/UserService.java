package com.bookstore.service;

import com.bookstore.model.User;
import com.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for user-related operations,
 * including finding, saving with password encryption,
 * and deleting users.
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs a UserService with the specified UserRepository and PasswordEncoder.
     *
     * @param userRepository  repository for user data access
     * @param passwordEncoder encoder to hash user passwords before saving
     */
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return the User object if found; null otherwise
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Saves a user, encoding their password before persistence.
     *
     * @param user the user to save
     * @return the saved User object
     */
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Deletes the specified user.
     *
     * @param user the User entity to delete
     */
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    /**
     * Deletes a user by their username.
     *
     * @param username the username of the user to delete
     */
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
