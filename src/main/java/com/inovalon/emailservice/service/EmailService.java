package com.inovalon.emailservice.service;


import com.inovalon.emailservice.dto.EmailRequestDTO;

public interface EmailService {
    void sendEmail(EmailRequestDTO request) throws Exception;
}
