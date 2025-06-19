package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

/**
 * Represents a user of the bookstore application.
 * This class is mapped to the "users" table in the database.
 */
@Table("users")
public class User {

    /**
     * The unique ID of the user.
     */
    @Id
    private Long id;

    /**
     * The username used to log in.
     */
    @Column("username")
    private String username;

    /**
     * The encrypted password for the user.
     */
    @Column("password")
    private String password;

    /**
     * The email address of the user.
     */
    @Column("email")
    private String email;

    /**
     * The phone number of the user.
     */
    @Column("phone_number")
    private String phoneNumber;

    /**
     * Constructs a new User with the given values.
     *
     * @param username     the username
     * @param password     the password
     * @param email        the user's email
     * @param phoneNumber  the user's phone number
     */
    public User(String username, String password, String email, String phoneNumber) {
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the user's ID.
     *
     * @return the user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     *
     * @param id the user ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the user's username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user's phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
