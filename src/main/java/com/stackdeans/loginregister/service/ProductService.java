package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Product;
import com.stackdeans.loginregister.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

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

    public List<Product> searchByProductName(String name) {
        return productRepository.search(name);
    }


    public Page<Product> searchByProductName1(String name,
                                              Optional<Integer> page, Optional<String> sortBy
    ) {
        return productRepository.searchfor(name, PageRequest.of(
                page.orElse(0),
                5, Sort.Direction.ASC,
                sortBy.orElse("id")
        ));
    }

    public List<Product> topSellingProducts(int noOfSellings) {
        List<Product> products = productRepository.searchForTop()
                .stream()
                .filter(c -> c.getNoOfSellings() > noOfSellings)
                .collect(Collectors.toList());
        return products;
    }

    public Page<Product> getAllProducts(
            Optional<Integer> page,
            Optional<String> sortBy
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
