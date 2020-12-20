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
import com.group3.backend.ui.model.request.MedicationOrderStatusRequest;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.EmailStatusResponse;

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
    
    @PostMapping(path="/accept")
    public EmailResponse acceptMedicationRequest(@RequestBody MedicationOrderStatusRequest medOrderStatusRequest) {
        return emailService.acceptMedicationRequest(medOrderStatusRequest);
    }
    
    @PostMapping(path="/reject")
    public EmailResponse rejectMedicationRequest(@RequestBody MedicationOrderStatusRequest medOrderStatusRequest) {
        return emailService.rejectMedicationRequest(medOrderStatusRequest);
    }
    
    @GetMapping(path="/details")
    public EmailStatusResponse rejectMedicationRequest(@RequestParam String id) {
        return emailService.getMedicationRequestDetails(id);
    }
}
