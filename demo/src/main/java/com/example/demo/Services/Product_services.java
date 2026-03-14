package com.example.demo.Services;

import com.example.demo.Model.Products;
import com.example.demo.Repo.Product_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_services {
    @Autowired
    Product_repo repo;

    public List<Products> getproducts() {
        return repo.findAll();
    }

    public Products getbyproductbyid(int productId) {
        return repo.findById(productId).orElse(null);
    }

    public void addproducts(Products product) {
         repo.save(product);
    }
}
