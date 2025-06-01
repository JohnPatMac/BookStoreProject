package com.bookstore.service;

import com.bookstore.model.Product;
import com.bookstore.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

	public List<Product> findByGenre(String genre) {
		return productRepository.findByGenreIgnoreCase(genre);
	}

	public List<Product> findByFormat(String format) {
		return productRepository.findByFormatIgnoreCase(format);
	}

	public List<Product> findByPriceUnder(double price) {
		return productRepository.findByPriceLessThanEqual(price);
	}
}
