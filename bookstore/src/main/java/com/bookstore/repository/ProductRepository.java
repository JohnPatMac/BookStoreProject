package com.bookstore.repository;

import com.bookstore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for performing CRUD operations on Product entities.
 * Extends Spring Data's CrudRepository to provide basic CRUD functionality.
 */
public interface ProductRepository extends CrudRepository<Product, Long>
{
    /**
     * Finds all products that match the given format.
     *
     * @param format The format of the product (e.g., Hardcover, Paperback).
     * @return A list of products that match the format.
     */
    List<Product> findByFormatIgnoreCase(String format);

    /**
     * Finds all products that match the given genre.
     *
     * @param genre The genre of the product (e.g., Fiction, Fantasy).
     * @return A list of products that match the genre.
     */
    List<Product> findByGenreIgnoreCase(String genre);

    /**
     * Finds all products with a price less than or equal to the specified amount.
     *
     * @param price The maximum price.
     * @return A list of products within the specified price range.
     */
    List<Product> findByPriceLessThanEqual(double price);
}

