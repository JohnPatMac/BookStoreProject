package com.gcu.repository;

import com.gcu.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>
{
	//boolean existsByIsbn(String isbn);
}
