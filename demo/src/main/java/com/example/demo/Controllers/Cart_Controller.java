package com.example.demo.Controllers;

import com.example.demo.Model.Cart;
import com.example.demo.Services.Cart_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Cart_Controller {
    @Autowired
    Cart_Services services;

    @PostMapping("/add")
    public String addcart(@RequestBody Cart cart)
    {
        services.addcart(cart);
        return "updated";
    }

    @GetMapping("/get/{id}")
    public Cart getbyid(@PathVariable int id)
    {
        return services.getbyid(id);
    }

    @DeleteMapping("/cart/remove/{id}")
    public Cart removeid(@PathVariable int id)
    {
        return services.removebyid(id);
    }
}
