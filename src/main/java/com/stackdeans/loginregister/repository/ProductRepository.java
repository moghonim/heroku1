package com.stackdeans.loginregister.repository;

import com.stackdeans.loginregister.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ghonim
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
