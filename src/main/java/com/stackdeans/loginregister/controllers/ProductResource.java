package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.repository.ProductRepository;
import com.stackdeans.loginregister.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ghonim
 */
@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/get")
    public Product get(@RequestParam("id") Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping(value = "/add")
    public List<Product> persist(@RequestBody final Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    @DeleteMapping(value = "/delete")
    public List<Product> delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @PutMapping(value = "/put/{id}")
    public List<Product> put(@PathVariable Long id, @RequestBody Product product) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            productRepository.save(product);
        }
        return productRepository.findAll();
    }

    @GetMapping("/search-by-product-name/{name}")
    public List<Product> searchByProductName(@PathVariable String name) {
        return productService.searchByProductName(name);
    }


    @GetMapping("/search-by-product-name1/{name}")
    public Page<Product> searchByProductName1(@PathVariable String name,
                                              @RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy
    ) {

//        PageRequest pageRequest=PageRequest.of(
//                page.orElse(0),
//                5, Sort.Direction.ASC,
//                sortBy.orElse("id"));


        return productRepository.searchfor(name, PageRequest.of(
                page.orElse(0),
                5, Sort.Direction.ASC,
                sortBy.orElse("id")
        ));


    }


    @GetMapping("/top/{noOfSellings}")
    public List<Product> topSellingProducts(@PathVariable int noOfSellings) {
        List<Product> products = productRepository.searchForTop()
                .stream()
                .filter(c -> c.getNoOfSellings() > noOfSellings)
                .collect(Collectors.toList());

        return products;

    }


    @GetMapping(value = "/pageofproducts")
    Page<Product> getAllProducts(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
        return productRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        5, Sort.Direction.ASC,
                        sortBy.orElse("id")
                )
        );
    }
}
