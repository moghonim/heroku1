package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.Category;
import com.stackdeans.loginregister.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ghonim
 */
@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping(value = "/get")
    public Category get(@RequestParam("id") Long id) {
        return categoryService.getById(id);
    }

    @PostMapping(value = "/add")
    public List<Category> persist(@RequestBody final Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping(value = "/delete")
    public List<Category> delete(@PathVariable Long id) {
        return categoryService.deleteById(id);
    }

    @PutMapping(value = "/put/{id}")
    public List<Category> put(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.put(id, category);
    }
}
