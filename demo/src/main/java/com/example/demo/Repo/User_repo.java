package com.example.demo.Repo;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface User_repo extends JpaRepository<User,Integer> {

   Optional<User> findByEmail(String email);  //edhula dhan is present() method iruku

    User findByname(String username);

    //User findByEmail(String email);
}
