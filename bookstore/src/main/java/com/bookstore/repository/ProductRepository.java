package com.bookstore.repository;

import com.bookstore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>
{

	List<Product> findByFormatIgnoreCase(String format);

	List<Product> findByGenreIgnoreCase(String genre);

	List<Product> findByPriceLessThanEqual(double price);

}
