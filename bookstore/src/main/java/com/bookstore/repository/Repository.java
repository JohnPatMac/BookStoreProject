package com.bookstore.repository;

import com.bookstore.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

// Repo extends Crud
public interface Repository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM users WHERE username = :username")
    User findByUsername(String username);
}
