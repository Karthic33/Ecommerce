package com.example.demo.Repo;

import com.example.demo.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_repo extends JpaRepository<Cart,Integer> {

}
