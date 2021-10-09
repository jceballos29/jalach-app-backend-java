package com.jalach.jalach.services;

import java.util.List;

import com.jalach.jalach.models.Product;

public interface ProductService {
    Product registerProduct(Product product);
    List<Product> getProductsByCompany(Integer rut);
    List<Product> getProductByCode(String code);
    Product updateProduct(Long code, Product updatedProduct);
    Product deleteProduct(Long code);

}
