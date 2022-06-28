package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Category;
import com.stackdeans.loginregister.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Category> save(final Category category) {
        categoryRepository.save(category);
        return categoryRepository.findAll();
    }

    public List<Category> deleteById(Long id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findAll();
    }

    public List<Category> put(Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            categoryRepository.save(category);
        }

        return categoryRepository.findAll();
    }
}
