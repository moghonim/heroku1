package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> persist(final Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    public List<Product> delete(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public List<Product> put(Long id, Product product) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            productRepository.save(product);
        }
        return productRepository.findAll();
    }

}
