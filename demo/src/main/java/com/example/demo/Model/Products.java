package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String description;
    private Double price;



    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order_item> orderItems;

    @OneToMany(mappedBy = "product")
//    @JsonManagedReference
    private List<Cart_items> cartItems;


}
