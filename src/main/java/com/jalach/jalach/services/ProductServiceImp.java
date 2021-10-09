package com.jalach.jalach.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jalach.jalach.models.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ProductServiceImp implements ProductService{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product registerProduct(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public List<Product> getProductsByCompany(Integer rut) {
        String query = "FROM Product WHERE business_rut = :rut";
        return entityManager.createQuery(query, Product.class).setParameter("rut", rut).getResultList();
    }

    @Override
    public List<Product> getProductByCode(String code) {
        String query = "FROM Product WHERE category_code = :code";
        return entityManager.createQuery(query, Product.class).setParameter("code", code).getResultList();
    }

    @Override
    public Product updateProduct(Long code, Product updatedProduct) {
        Product product = entityManager.find(Product.class, code);
        if(product != null){
            return entityManager.merge(updatedProduct);
        }
        return null;
    }

    @Override
    public Product deleteProduct(Long code) {
        Product product = entityManager.find(Product.class, code);
        if(product != null){
            entityManager.remove(product);
            return product;
        }
        return null;
    }
    
}
