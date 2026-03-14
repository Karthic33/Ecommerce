package com.example.demo.Repo;

import com.example.demo.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
