package com.bookstore.controller;

import com.bookstore.model.Product;
import com.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ProductService productService;

    @GetMapping("/genre/{genre}")
    public String productsByGenre(@PathVariable String genre, Model model) {
        List<Product> products = productService.findByGenre(genre);
        model.addAttribute("products", products);
        model.addAttribute("categoryName", genre);
        return "categories";
    }

    @GetMapping("/format/{format}")
    public String getProductsByFormat(@PathVariable String format, Model model) {
        List<Product> products = productService.findByFormat(format);
        model.addAttribute("products", products);
        model.addAttribute("categoryName", format);
        return "categories";
    }

    @GetMapping("/price/under10")
    public String getProductsUnderTen(Model model) {
        List<Product> products = productService.findByPriceUnder(10.00);
        model.addAttribute("products", products);
        model.addAttribute("categoryName", "Under $10");
        return "categories";
    }
}
