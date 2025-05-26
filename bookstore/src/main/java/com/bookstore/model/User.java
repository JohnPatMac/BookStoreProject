package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Table("users")
public class User {
	@Id
    private Long id;
    @Column("username")
    private String username;
    @Column("password")
    private String password;
    @Column("email")
    private String email;
    @Column("phoneNumber")
    private String phoneNumber;

    public User(String username, String password, String email, String phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
