package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventory_id;
    private int quantity;


    @OneToOne
    @JoinColumn(name = "product_id",unique = true)
    private Products product;

}
