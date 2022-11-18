package com.learn.learning.services;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

    public void sendEmailWithAttachment(String to, String body, String subject, String attachment)throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("mtskrmarzuki67@gmail.com");
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body);
        mimeMessage.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

        javaMailSender.send(mimeMessage);
        System.out.println("Mail send...");

    }
}
