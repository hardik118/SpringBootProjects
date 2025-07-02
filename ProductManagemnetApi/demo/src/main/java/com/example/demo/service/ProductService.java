package com.example.demo.service;

import com.example.demo.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private  final ProductRepository productRepository;

    @Autowired
    public  ProductService(ProductRepository productRepository){
        this.productRepository= productRepository;

    }

    public Product createProduct(Product product) {
        if (product.getProductName() == null || product.getProductName().isEmpty()) {
            throw new IllegalArgumentException("product name is either missing or not passed !");

        }
        return productRepository.save(product);
    }
        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

}
