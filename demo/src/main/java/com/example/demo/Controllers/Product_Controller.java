package com.example.demo.Controllers;

import com.example.demo.Model.Products;
import com.example.demo.Services.Product_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Product_Controller {

    @Autowired
    Product_services services;

    @GetMapping("/get/products")
    public List<Products> getproducts()
    {
        return services.getproducts();
    }

    @GetMapping("/get/{product_id}")
    public Products getproductbyid(@PathVariable int product_id)
    {
        return services.getbyproductbyid(product_id);
    }

    @PostMapping("/add/products")
    public String addproducts(@RequestBody Products product)
    {
        services.addproducts(product);
        return "updated";
    }
}
