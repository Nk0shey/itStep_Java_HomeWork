package com.nk0shey.itstep_exam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfig {

    @Value("${feature.email.enabled}")
    private boolean emailEnabled;

    public boolean isEmailEnabled() {
        return emailEnabled;
    }
}
