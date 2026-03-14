package com.example.demo.Services;

import com.example.demo.Model.Inventory;
import com.example.demo.Repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Inventoryservices {

    @Autowired
    InventoryRepo repo;

    public List<Inventory> getall() {
        return repo.findAll();
    }
}
