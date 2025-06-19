package com.bookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.*;

/**
 * Represents a product entity in the bookstore system.
 */
@Table("products")
public class Product {

    @Id
    private Long id;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Genre is required")
    private String genre;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Format is required")
    private String format;

    @NotNull(message = "Stock availability is required")
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;

    /**
     * Gets the ID of the product.
     * 
     * @return the product ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     * 
     * @param id the product ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ISBN of the product.
     * 
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the product.
     * 
     * @param isbn the ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the title of the product.
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the product.
     * 
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the product.
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the product.
     * 
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the genre of the product.
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the product.
     * 
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the price of the product.
     * 
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price the price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gets the format of the product (e.g., hardcover, paperback).
     * 
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the product.
     * 
     * @param format the format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets the stock quantity of the product.
     * 
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     * 
     * @param stock the stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Checks equality based on product ID.
     * 
     * @param o the object to compare
     * @return true if IDs are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    /**
     * Generates a hash code using the product ID.
     * 
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
