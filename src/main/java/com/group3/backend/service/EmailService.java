package com.group3.backend.service;

public interface EmailService {
    void sendMail(String to, String subject, String body);
}
