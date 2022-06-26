package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Category;
import com.stackdeans.loginregister.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ghonim
 */
@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(value = "/all")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    /**
     * Gets category.
     *
     * @return category if exists
     */
    @GetMapping(value = "/get")
    public Category get(@RequestParam("id") Long id) {
        return categoryRepository.findById(id).get();
    }

    /**
     * Persist category.
     *
     * @param category the category
     * @return the list
     */
    @PostMapping(value = "/add")
    public List<Category> persist(@RequestBody final Category category) {
        categoryRepository.save(category);
        return categoryRepository.findAll();
    }

    @DeleteMapping(value = "/delete")
    public List<Category> delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findAll();
    }

    @PutMapping(value = "/put/{id}")
    public List<Category> put(@PathVariable Long id, @RequestBody Category category) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            categoryRepository.save(category);
        }

        return categoryRepository.findAll();
    }
}
