package com.nk0shey.itstep_exam.service;

import com.nk0shey.itstep_exam.config.EmailConfig;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailConfig config;

    public EmailService(EmailConfig config) {
        this.config = config;
    }

    public void sendEmail(String recipient) {
        if (config.isEmailEnabled()) {
            System.out.println("Надсилаємо email до: " + recipient);
        } else {
            System.out.println("Відправка вимкнена через конфіг.");
        }
    }
}
