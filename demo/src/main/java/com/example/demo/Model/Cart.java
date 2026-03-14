package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Cart_items> cartItems;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Cart_items> cartItems;



}
