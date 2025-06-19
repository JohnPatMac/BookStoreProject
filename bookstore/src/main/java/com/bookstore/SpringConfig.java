package com.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.model.UserLogin;
import com.bookstore.model.UserRegister;

/**
 * Spring configuration class that defines beans for
 * UserLogin and UserRegister model objects.
 */
@Configuration
public class SpringConfig {
    
    /**
     * Creates and returns a new UserLogin bean.
     *
     * @return a new UserLogin instance
     */
    @Bean(name = "userLogin")
    public UserLogin getUserLogin() {
        return new UserLogin();
    }
    
    /**
     * Creates and returns a new UserRegister bean.
     *
     * @return a new UserRegister instance
     */
    @Bean(name = "userRegister")
    public UserRegister getUserRegister() {
        return new UserRegister();
    }
}
