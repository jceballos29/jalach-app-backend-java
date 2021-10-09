package com.jalach.jalach.controllers;

import java.util.List;

import com.jalach.jalach.models.Category;
import com.jalach.jalach.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping(value = "/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @PostMapping(value="/category")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @DeleteMapping(value="/category/{code}")
    public Category deleteCategory(@PathVariable String code) {
        return categoryService.deleteCategory(code);
    }
    
    @GetMapping(value="/category/{rut}")
    public List<Category> getCategoriesOf(@PathVariable Integer rut) {
        return categoryService.getCategoriesOf(rut);
    }
    
}
