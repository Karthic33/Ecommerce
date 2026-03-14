package com.example.demo.Services;

import com.example.demo.Filter.Jwtservice;
import com.example.demo.Model.User;
import com.example.demo.Repo.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class User_Services {
        @Autowired
        private User_repo repo;
        @Autowired
        AuthenticationManager authmanagaer;

        @Autowired
        private Jwtservice jwtservice;
        private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

//        public User register(User user) {
//
//            Optional<User> existingUser =
//                    repo.findByEmail(user.getEmail());
//
//            if (existingUser.isPresent()) {
//                throw new RuntimeException("User already exists");
//            }
//            return repo.save(user);
//        }

    public User register(User user) {

        Optional<User> existingUser = repo.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(encoder.encode(user.getPassword())); // IMPORTANT
        user.getAddress();
        return repo.save(user);
    }
//        public String login(User user) {
//
//            Optional<User> existingUser =
//                    repo.findByEmail(user.getEmail());
//
//            if (existingUser.isEmpty()) {
//                throw new RuntimeException("User not found");
//            }
//
//            if (!existingUser.get().getPassword()
//                    .equals(user.getPassword())) {
//                throw new RuntimeException("Invalid password");
//            }
//
//            return "Login successful";
//        }
    public String login(User user) {
    Authentication authentication=authmanagaer.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
    {
        if(authentication.isAuthenticated()) {
            return jwtservice.generatedtoken(user.getName());
        }
    }
    return "fail";
}


    public User getbyuserid(int user_id) {
    return repo.findById(user_id)
            .orElseThrow(() ->
                    new RuntimeException("User not found"));
}
}
