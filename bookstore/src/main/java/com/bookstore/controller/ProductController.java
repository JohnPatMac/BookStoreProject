package com.bookstore.controller;


import com.bookstore.model.Product;
import com.bookstore.service.ProductService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	 public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @GetMapping("/products/new")
	    public String showCreateForm(Model model) {
	        model.addAttribute("product", new Product());
	        return "productform";
	    }

	    @PostMapping("/products/new")
	    public String submitForm(@Valid @ModelAttribute("product") Product product,
	                             BindingResult bindingResult,
	                             Model model) {
	        if (bindingResult.hasErrors()) {
	            return "productform";
	        }

	        try {
	            productService.saveProduct(product);
	            model.addAttribute("product", new Product());
	            model.addAttribute("successMessage", "Product created successfully!");
	        } catch (RuntimeException e) {
	            bindingResult.rejectValue("isbn", "error.product", e.getMessage());
	            return "productform";
	        }

	        return "productform";
	    }
	    
	    @GetMapping("/products/update")
	    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
	    	model.addAttribute("product", productService.getProductById(id));
	    	return "update_product";
	    }
	    
	    @PostMapping("/products/update")
	    public String submitUpdate(@Valid @ModelAttribute("product") Product product,
	                             BindingResult bindingResult,
	                             Model model) {
	    	if (bindingResult.hasErrors()) {
	            return "update_product";
	        }
	    	
	    	try {
	            productService.saveProduct(product);
	            model.addAttribute("successMessage", "Product updated.");
	            return "redirect:/books";
	    	} catch (Exception e) {
	            bindingResult.rejectValue("isbn", "error.product", e.getMessage());
	        }
	    	
	    	return "update_product";
	    }

	    @GetMapping("/books")
	    public String showBrowseBooksPage(Model model) {
	        List<Product> products = productService.getAllProducts();
	        model.addAttribute("products", products);
	        return "books";
	    }


}
