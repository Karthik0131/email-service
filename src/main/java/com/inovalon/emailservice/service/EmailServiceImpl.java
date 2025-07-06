package com.inovalon.emailservice.service;

import com.inovalon.emailservice.dto.EmailRequestDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final Configuration freemarkerConfig;

    @Override
    public void sendEmail(EmailRequestDTO request) throws Exception {
        // Merge Freemarker data model
        Map<String, Object> model = new HashMap<>();
        model.put("name", request.getName());
        model.putAll(request.getExtractConfig());

        // Load and process the template
        Template template = freemarkerConfig.getTemplate(request.getTemplateId() + ".ftl");
        StringWriter writer = new StringWriter();
        template.process(model, writer);

        // Create and send email
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(request.getToAddresses().toArray(new String[0]));
        helper.setSubject(request.getSubject());
        helper.setText(writer.toString(), true); // true = HTML content

        helper.setFrom("karthikeyatvs2004@gmail.com","Karthik");

        javaMailSender.send(message);
    }
}