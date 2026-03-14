package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Order_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;
    private int quantity;
    private double price_at_purchase;


    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;


}
