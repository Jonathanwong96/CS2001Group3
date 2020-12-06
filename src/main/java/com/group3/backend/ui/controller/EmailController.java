package com.group3.backend.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.service.EmailService;
import com.group3.backend.ui.model.request.EmailRequest;
import com.group3.backend.ui.model.response.EmailResponse;

@RestController //So we can use GET, POST, PUT methods
@RequestMapping("email") //to define the URL. oursite.com/email
public class EmailController {

    @Autowired
    EmailService emailService;
    
    @GetMapping
    public ArrayList<EmailResponse> getAllEmailRequests(@RequestParam String careHomeName) {
    	return emailService.getAllEmailsForCareHome(careHomeName);
    }

    @PostMapping
    public EmailResponse sendEmail(@RequestBody EmailRequest emailRequest) {
    	//for now just sending the emailRequest with all fields. Once logins are introduced can reduce the fields that emailRequest accepts and get them from the user jwt.
    	return emailService.sendEmail(emailRequest);
    }
    
    @GetMapping(path="/accept")
    public EmailResponse acceptMedicationRequest(@RequestParam String id) {
        return emailService.acceptMedicationRequest(id);
    }
    
    @GetMapping(path="/reject")
    public EmailResponse rejectMedicationRequest(@RequestParam String id) {
        return emailService.rejectMedicationRequest(id);
    }
}
