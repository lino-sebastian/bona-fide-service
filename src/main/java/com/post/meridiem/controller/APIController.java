package com.post.meridiem.controller;

import com.post.meridiem.model.Product;
import com.post.meridiem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class APIController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

}
