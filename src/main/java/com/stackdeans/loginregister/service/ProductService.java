package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> searchByProductName(String productName) {
        return productRepository.search(productName);
    }

    public List<Product> topProduct(int numberOfSellings) {
        return productRepository.searchForTop();
    }
}
