package edu.nikt.lab1.controllers;

import edu.nikt.lab1.models.Category;
import edu.nikt.lab1.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> listCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }
    @PostMapping
    public Category save(@Valid Category category) {
        return this.categoryService.save(category);
    }
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @Valid Category category) {
        return this.categoryService.update(id, category );
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.categoryService.deleteById(id);
    }
}
