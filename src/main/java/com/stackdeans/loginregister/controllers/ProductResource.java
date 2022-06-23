package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ghonim
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductResource {

    /**
     * The product repository.
     */
    @Autowired
    private ProductRepository productRepository;


    @GetMapping(value = "/all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/get")
    public Product get(@RequestParam("id") int id) {
        return productRepository.findById(id).get();
    }

    @PostMapping(value = "/add")
    public List<Product> persist(@RequestBody final Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    @DeleteMapping(value = "/delete")
    public List<Product> delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @PutMapping(value = "/put/{id}")
    public List<Product> put(@PathVariable int id, @RequestBody Product product) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            productRepository.save(product);
        }

        return productRepository.findAll();
    }
}