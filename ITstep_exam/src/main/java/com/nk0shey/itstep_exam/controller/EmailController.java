package com.nk0shey.itstep_exam.controller;

import com.nk0shey.itstep_exam.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String send(@RequestParam String to) {
        emailService.sendEmail(to);
        return "Перевірка логів завершена.";
    }
}
