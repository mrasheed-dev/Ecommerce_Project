package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public String sendEmail(

            @RequestParam String to,

            @RequestParam String subject,

            @RequestParam String text
    ) {

        service.sendEmail(
                to,
                subject,
                text
        );

        return "Email sent successfully";
    }
}
