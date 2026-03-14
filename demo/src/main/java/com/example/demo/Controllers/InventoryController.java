package com.example.demo.Controllers;


import com.example.demo.Model.Inventory;
import com.example.demo.Repo.InventoryRepo;
import com.example.demo.Services.Inventoryservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {



        @Autowired
        Inventoryservices services;

        @GetMapping("/get")
        public List<Inventory> getInventory(){
            return services.getall();
        }
    }

