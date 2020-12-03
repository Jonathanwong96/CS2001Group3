package com.group3.backend.service.impl;

import com.group3.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String to, String subject, String body) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom("carehomehelper@gmail.com");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(body);

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
