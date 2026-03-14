package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {
    @Autowired
    Emailservice emailService;

        private Map<String,String> otpStorage = new HashMap<>();

        public void generateOtp(String email) {

            String otp = String.valueOf(100000 + new Random().nextInt(900000));

            otpStorage.put(email, otp);
            emailService.sendOtp(email, otp);
            // send email logic
        }

//        public boolean verifyOtp(String email, String otp) {
//
//
//            return otp.equals(otpStorage.get(email));
//        }

    public boolean verifyOtp(String email, String otp) {

        if(otp.equals(otpStorage.get(email))) {
            otpStorage.remove(email);
            return true;
        }

        return false;
    }
    }
