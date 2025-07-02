package com.example.demo.controller;

import com.example.demo.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    private  final ProductService productService;

    @Autowired
    public  ProductController(ProductService productService){
        this.productService= productService;

    }
    @PostMapping
    public ResponseEntity<Product> CreateProduct(@RequestBody Product product){
        Product createProduct= productService.createProduct(product);
        return  new ResponseEntity<>(createProduct, HttpStatus.CREATED);

    }
    @GetMapping
    public List<Product> getAllProducts(){
        return  productService.getAllProducts();

    }


}
