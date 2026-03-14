package com.example.demo.Repo;

import com.example.demo.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_repo extends JpaRepository<Products,Integer> {
}
