package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailservice {

        @Autowired
        private JavaMailSender mailSender;

        public void sendOtp(String email, String otp) {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(email);
            message.setSubject("Email Verification OTP");
           // message.setText("Your OTP is: " + otp);
            message.setText(
                    "Hello,\n\n" +
                            "Thank you for registering with our application.\n\n" +
                            "Your Email Verification OTP is: " + otp + "\n\n" +
                            "This OTP is valid for 5 minutes.\n" +
                            "Please do not share this OTP with anyone.\n\n" +
                            "If you did not request this, please ignore this email.\n\n" +
                            "Regards,\n" +
                            "Basic Project Team"
            );
            message.setFrom("karthickeyancr7@gmail.com");
            //message.setFrom("yourgmail@gmail.com");

            mailSender.send(message);
        }
    }