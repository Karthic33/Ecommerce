package com.example.demo.Repo;

import com.example.demo.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adressrepo extends JpaRepository<Address,Integer> {
}
