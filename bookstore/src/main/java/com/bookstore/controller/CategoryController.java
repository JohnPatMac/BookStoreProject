package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bookstore.model.Product;
import com.bookstore.service.ProductService;
import java.util.List;

/**
 * Controller for handling requests related to product categories,
 * such as filtering products by genre, format, or price range.
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ProductService productService;

    /**
     * Handles GET requests to fetch products by genre.
     *
     * @param genre the genre to filter products by
     * @param model the model to add attributes for the view
     * @return the view name "categories" to display the products
     */
    @GetMapping("/genre/{genre}")
    public String productsByGenre(@PathVariable String genre, Model model) {
        List<Product> products = productService.findByGenre(genre);
        model.addAttribute("products", products);
        model.addAttribute("categoryName", genre);
        return "categories";
    }

    /**
     * Handles GET requests to fetch products by format.
     *
     * @param format the format to filter products by
     * @param model the model to add attributes for the view
     * @return the view name "categories" to display the products
     */
    @GetMapping("/format/{format}")
    public String getProductsByFormat(@PathVariable String format, Model model) {
        List<Product> products = productService.findByFormat(format);
        model.addAttribute("products", products);
        model.addAttribute("categoryName", format);
        return "categories";
    }

    /**
     * Handles GET requests to fetch products priced under $10.
     *
     * @param model the model to add attributes for the view
     * @return the view name "categories" to display the products
     */
    @GetMapping("/price/under10")
    public String getProductsUnderTen(Model model) {
        List<Product> products = productService.findByPriceUnder(10.00);
        model.addAttribute("products", products);
        model.addAttribute("categoryName", "Under $10");
        return "categories";
    }
}
