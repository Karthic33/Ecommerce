package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String name;
    @Email
    private String email;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Address> address;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Address> address;





}
