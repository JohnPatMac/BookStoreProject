package com.bookstore;

import org.springframework.context.annotation.*;

import com.bookstore.model.UserLogin;
import com.bookstore.model.UserRegister;

@Configuration
public class SpringConfig {
	
	@Bean(name="userLogin")
	public UserLogin getUserLogin()
	{
		return new UserLogin();
	}
	
	@Bean(name="userRegister")
	public UserRegister getUserRegister()
	{
		return new UserRegister();
	}
}
