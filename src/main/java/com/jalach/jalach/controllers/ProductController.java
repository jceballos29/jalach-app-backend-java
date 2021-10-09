package com.jalach.jalach.controllers;

import java.util.List;

import com.jalach.jalach.models.Product;
import com.jalach.jalach.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping(value = "/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value="/products")
    public Product registerProduct(@RequestBody Product product) {
        return productService.registerProduct(product);
    }
    
    @GetMapping(value="/products/company/{rut}")
    public List<Product> getProductsByCompany(@PathVariable Integer rut) {
        return productService.getProductsByCompany(rut);
    }
    
    @GetMapping(value = "/products/category/{code}")
    public List<Product> getProductByCode(@PathVariable String code){
        return productService.getProductByCode(code);
    }

    @PutMapping(value="/products/{code}")
    public Product updateProduct(@PathVariable Long code, @RequestBody Product updatedProduct) {
        return productService.updateProduct(code, updatedProduct);
    }


    @DeleteMapping(value="/products/{code}")
    public Product deleteProduct(@PathVariable Long code) {
        return productService.deleteProduct(code);
    }
}
