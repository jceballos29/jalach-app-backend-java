package com.jalach.jalach.services;

import java.util.List;

import com.jalach.jalach.models.Category;

public interface CategoryService{
    
    Category createCategory(Category category);
    Category deleteCategory(String code);
    List<Category> getCategoriesOf(Integer rut);
}
