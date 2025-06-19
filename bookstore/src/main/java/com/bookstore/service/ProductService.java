package com.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.model.Product;
import com.bookstore.repository.ProductRepository;

/**
 * Service class for managing product-related operations
 * such as saving, retrieving, and deleting products.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructs a ProductService with the given ProductRepository.
     *
     * @param productRepository the repository used for product data operations
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Saves a product to the repository.
     *
     * @param product the product to save
     * @return the saved product instance
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the product with the given ID, or null if not found
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    /**
     * Finds products by genre, ignoring case.
     *
     * @param genre the genre to search by
     * @return a list of products matching the genre
     */
    public List<Product> findByGenre(String genre) {
        return productRepository.findByGenreIgnoreCase(genre);
    }

    /**
     * Finds products by format, ignoring case.
     *
     * @param format the format to search by
     * @return a list of products matching the format
     */
    public List<Product> findByFormat(String format) {
        return productRepository.findByFormatIgnoreCase(format);
    }

    /**
     * Finds products with a price less than or equal to the specified amount.
     *
     * @param price the maximum price
     * @return a list of products priced under or equal to the specified amount
     */
    public List<Product> findByPriceUnder(double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }
}
