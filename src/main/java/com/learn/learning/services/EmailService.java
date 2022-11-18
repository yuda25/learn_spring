package com.learn.learning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mtskrmarzuki67@gmail.com");
        message.setTo(to);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

        System.out.println("mail send successfully");
    }
}
