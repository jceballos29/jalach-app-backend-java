package com.jalach.jalach.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jalach.jalach.models.Category;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryServiceImp implements CategoryService{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Category createCategory(Category category) {
        return entityManager.merge(category);
    }

    @Override
    public Category deleteCategory(String code) {
        Category category = entityManager.find(Category.class, code);
        if(category != null){
            entityManager.remove(category);
            return category;
        }
        return null;
    }

    @Override
    public List<Category> getCategoriesOf(Integer rut) {
        String query = "FROM Category WHERE business_rut = :rut";
        return entityManager.createQuery(query, Category.class).setParameter("rut", rut).getResultList();
    }
    
}
