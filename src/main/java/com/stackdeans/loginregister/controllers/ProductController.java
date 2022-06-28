package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Ghonim
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping(value = "/get")
    public Product get(@RequestParam("id") Long id) {
        return productService.get(id);
    }

    @PostMapping(value = "/add")
    public List<Product> persist(@RequestBody final Product product) {
        return productService.persist(product);
    }

    @DeleteMapping(value = "/delete")
    public List<Product> delete(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PutMapping(value = "/put/{id}")
    public List<Product> put(@PathVariable Long id, @RequestBody Product product) {
        return productService.put(id, product);
    }
    @GetMapping("/search-by-product-name/{name}")
    public List<Product> searchByProductName(@PathVariable String name) {
        return productService.searchByProductName(name);
    }


    @GetMapping("/search-by-product-name1/{name}")
    public Page<Product> searchByProductName1(@PathVariable String name,
                                              @RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy
    ) {
        return productService.searchByProductName1(name, page, sortBy);
    }
    @GetMapping("/top/{noOfSellings}")
    public List<Product> topSellingProducts(@PathVariable int noOfSellings) {
        return productService.topSellingProducts(noOfSellings);
    }


    @GetMapping(value = "/pageofproducts")
    Page<Product> getAllProducts(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
        return productService.getAllProducts(page, sortBy);
    }
}
