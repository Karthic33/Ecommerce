package com.example.demo.Controllers;

import com.example.demo.Model.Orders;
import com.example.demo.Services.Order_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class Order_controller {
    @Autowired
    Order_services services;

    @GetMapping("/get/orders/{order_id}")
    public Orders getbyid(@PathVariable int order_id)
    {
        return services.getbyid(order_id);
    }

    @PostMapping("/orders/place")
    public String placeOrder(@RequestBody Orders order)
    {
        services.placeOrder(order);
        return "orderplaced";
    }
}
