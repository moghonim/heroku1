package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.repository.ProductRepository;
import com.stackdeans.loginregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorResource {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/addnewproduct")
    @PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
    public List<Product> persist(@RequestBody final Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    @DeleteMapping(value = "/delete")
    @PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
    public List<Product> delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @PutMapping(value = "/put/{id}")
    @PreAuthorize("hasRole('VENDOR') or hasRole('ADMIN')")
    public List<Product> put(@PathVariable Long id, @RequestBody Product product) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            productRepository.save(product);
        }
        return productRepository.findAll();
    }


}
