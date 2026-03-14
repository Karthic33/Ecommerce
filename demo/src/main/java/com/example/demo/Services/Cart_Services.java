package com.example.demo.Services;

import com.example.demo.Model.Cart;
import com.example.demo.Repo.Cart_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cart_Services {
    @Autowired
    Cart_repo repo;
    public void addcart(Cart cart) {
        repo.save(cart);

    }

    public Cart getbyid(int id) {
        return repo.findById(id).orElse(null);
    }

    public Cart removebyid(int id) {

        Cart cart = repo.findById(id).orElse(null);

        if(cart != null){
            repo.deleteById(id);
        }

        return cart;
    }
}
