package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    private String city;
    private String country;
    private Long postalcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


}
