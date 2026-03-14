package com.example.demo.Repo;

import com.example.demo.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_repo extends JpaRepository<Orders,Integer> {
}
