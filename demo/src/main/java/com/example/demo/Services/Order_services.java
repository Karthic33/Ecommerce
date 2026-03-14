package com.example.demo.Services;

import com.example.demo.Controllers.Order_controller;
import com.example.demo.Model.Address;
import com.example.demo.Model.Orders;
import com.example.demo.Model.User;
import com.example.demo.Repo.Adressrepo;
import com.example.demo.Repo.Order_repo;
import com.example.demo.Repo.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order_services {
    @Autowired
    Order_repo order_repo;

    @Autowired
    User_repo repo;

    @Autowired
    Adressrepo addressRepo;

    public Orders getbyid(int id) {
        return order_repo.findById(id).orElse(null);
    }

//    public void placeOrder(Orders order) {
//        order_repo.save(order);
//    }

    public Orders placeOrder(Orders order)
    {
        User user = repo.findById(order.getUser().getUser_id()).orElse(null);
        Address address = addressRepo.findById(order.getAddress().getAddress_id()).orElse(null);

        order.setUser(user);
        order.setAddress(address);

        return order_repo.save(order);
    }


}
