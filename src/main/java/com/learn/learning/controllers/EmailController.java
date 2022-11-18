package com.learn.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.learning.dto.EmailDto;
import com.learn.learning.services.EmailService;

@RestController
@RequestMapping("mail")
public class EmailController {
    @Autowired
    EmailService emailService;
    
    @PostMapping("sendEmail")
    // @EventListener(ApplicationReadyEvent.class)
    public void send(@RequestBody EmailDto emailDto){
        // emailService.send("kym25@spambox.xyz", "test", "keep happy");
        emailService.send(emailDto.getTo(), emailDto.getSubject(), emailDto.getBody());
    }
}
