package com.bookstore.repository;

import com.bookstore.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for performing CRUD operations on User entities.
 * Extends CrudRepository to leverage Spring Data's standard methods.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return The User object if found, otherwise null.
     */
    User findByUsername(String username);  

    /**
     * Deletes the given user from the database.
     *
     * @param user The user to delete.
     */
    void delete(User user);         

    /**
     * Deletes a user based on their username.
     *
     * @param username The username of the user to delete.
     */
    void deleteByUsername(String username); 
}
