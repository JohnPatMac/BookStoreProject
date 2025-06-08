package com.bookstore.repository;

import com.bookstore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);  

    void delete(User user);         

    void deleteByUsername(String username); 
}
