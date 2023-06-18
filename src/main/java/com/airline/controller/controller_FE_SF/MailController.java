package com.airline.controller.controller_FE_SF;


import com.airline.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class MailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestParam("file") MultipartFile file) {
        String toEmail = "volamthienphu27082003@gmail.com";
        String subject = "Email subject";
        String body = "Email body";

        // Send email with PDF attachment
        emailSenderService.sendEmailWithAttachment(toEmail, subject, body, file);

        return ResponseEntity.ok("Email sent successfully.");
    }
}



