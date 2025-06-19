package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

/**
 * The main entry point for the Bookstore Spring Boot application.
 * 
 * This class bootstraps the application and enables JDBC repositories
 * scanning in the specified package.
 */
@SpringBootApplication
@EnableJdbcRepositories(basePackages = "com.bookstore.repository")
public class BookstoreApplication {

    /**
     * The main method to launch the Spring Boot application.
     * 
     * @param args command-line arguments passed during startup
     */
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
