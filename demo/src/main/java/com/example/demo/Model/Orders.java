package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.*;

@Entity
@Data
@RequiredArgsConstructor
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int order_id;

        private Date order_time;

        @ManyToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private User user;

        @ManyToOne
        @JoinColumn(name = "address_id")
        private Address address;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Order_item> items;

//        @ManyToOne
//        @JoinColumn(name = "user_id")
//        private User user;


    }