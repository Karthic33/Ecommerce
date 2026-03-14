package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Cart_items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Products product;

//    @ManyToOne
//    @JoinColumn(name="cart_id")
//    @JsonBackReference
//    private Cart cart;
//
//    @ManyToOne
//    @JoinColumn(name="product_id")
//    private Products product;


}
