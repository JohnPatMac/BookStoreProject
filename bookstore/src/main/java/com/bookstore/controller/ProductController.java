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

/**
 * Controller to handle web requests related to product management,
 * including creating, updating, viewing, and deleting products.
 */
@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    /**
     * Constructor for ProductController with injected ProductService.
     * 
     * @param productService the service to manage product operations
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Displays the form for creating a new product.
     * 
     * @param model the model to hold attributes for the view
     * @return the view name for the product creation form
     */
    @GetMapping("/products/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * Handles submission of the new product form.
     * Validates the product and saves it if valid.
     * 
     * @param product the product submitted by the form
     * @param bindingResult holds validation results
     * @param model the model to hold attributes for the view
     * @return the view name to show (form with errors or success)
     */
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
    
    /**
     * Displays the form to update an existing product identified by ID.
     * 
     * @param id the ID of the product to update
     * @param model the model to hold attributes for the view
     * @return the view name for the product update form
     */
    @GetMapping("/products/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "update_product";
    }
    
    /**
     * Handles submission of the product update form.
     * Validates and saves updated product data.
     * 
     * @param product the product data submitted by the form
     * @param bindingResult holds validation results
     * @param model the model to hold attributes for the view
     * @return redirect to books page on success, or form view on error
     */
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

    /**
     * Displays a list of all products.
     * 
     * @param model the model to hold attributes for the view
     * @return the view name to show the list of products
     */
    @GetMapping("/books")
    public String showBrowseBooksPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "books";
    }

    /**
     * Deletes a product by ID and redirects to the products list page.
     * 
     * @param id the ID of the product to delete
     * @param redirectAttributes used to pass flash attributes for success/error messages
     * @return redirect URL to the products list page
     */
    @GetMapping("/products/delete")
    public String deleteProduct(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            productService.deleteProduct(id);
            redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete the product.");
        }
        return "redirect:/books";
    }
}
