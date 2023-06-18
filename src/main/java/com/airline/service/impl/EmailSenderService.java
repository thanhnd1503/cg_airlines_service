package com.airline.service.impl;

import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.util.Base64;

@Service
@Transactional
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(String toEmail, String subject, String body, MultipartFile file) {
        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("volamthienphu27082003@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body);


            DataSource dataSource = new ByteArrayDataSource(file.getBytes(), file.getContentType());
            helper.addAttachment(file.getOriginalFilename(), dataSource);

            mailSender.send(message);
            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }
}



