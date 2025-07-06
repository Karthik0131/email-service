package com.inovalon.emailservice.controller;

import com.inovalon.emailservice.dto.EmailRequestDTO;
import com.inovalon.emailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequestDTO request) {
        try {
            emailService.sendEmail(request);
            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // For debug
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }
}
