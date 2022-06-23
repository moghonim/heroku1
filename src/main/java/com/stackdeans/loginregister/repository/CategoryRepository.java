package com.stackdeans.loginregister.repository;

import com.stackdeans.loginregister.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ghonim
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
