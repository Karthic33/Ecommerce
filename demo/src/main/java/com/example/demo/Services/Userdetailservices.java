package com.example.demo.Services;

import com.example.demo.Model.User;
import com.example.demo.Repo.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Userdetailservices implements UserDetailsService  {
    @Autowired
    User_repo repos;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users=repos.findByname(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new Userprinciple(users);
    }
}
