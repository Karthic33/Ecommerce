package com.example.demo.Controllers;

import com.example.demo.Model.User;
import com.example.demo.Services.Emailservice;
import com.example.demo.Services.OtpService;
import com.example.demo.Services.User_Services;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class User_Controller {

    @Autowired
    private Emailservice emailService;

    @Autowired
    User_Services services;


    @PostMapping("/register")
    public ResponseEntity<?> registereduser(@RequestBody User user) {
        try {
            User savedUser = services.register(user);
            return ResponseEntity.ok(savedUser);
        }
        catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
    @Autowired
    private OtpService otpService;

    @PostMapping("/registers")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {

        otpService.generateOtp(user.getEmail());

        return ResponseEntity.ok("OTP sent to your email");
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(@RequestParam String email,
                                       @RequestParam String otp,
                                       @RequestBody User user) {

        if (otpService.verifyOtp(email, otp)) {

            User savedUser = services.register(user);

            return ResponseEntity.ok(savedUser);
        }

        return ResponseEntity.badRequest().body("Invalid OTP");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            String message = services.login(user);
            return ResponseEntity.ok(message);
        }
        catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
    @GetMapping("/get/userid/{user_id}")
    public ResponseEntity<User> getbyid(@PathVariable int user_id) {
        User user = services.getbyuserid(user_id);
        return ResponseEntity.ok(user);

    }
    @GetMapping("/testmail")
    public String testMail() {
        emailService.sendOtp("karthickeyancr7@gmail.com","123456");
        return "Mail Sent";
    }
}