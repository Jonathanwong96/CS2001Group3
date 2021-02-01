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
import com.group3.backend.ui.model.request.NewEmailRequest;
import com.group3.backend.ui.model.response.EmailContentResponse;
import com.group3.backend.ui.model.response.EmailResponse;
import com.group3.backend.ui.model.response.EmailStatusResponse;

@RestController //So we can use GET, POST, PUT methods
@RequestMapping("email") //to define the URL. oursite.com/email
public class EmailController {

    @Autowired
    EmailService emailService;
    
    @GetMapping
    public ArrayList<EmailResponse> getAllEmailRequests(@RequestParam long careHomeId) {
    	return emailService.getAllEmailsForCareHome(careHomeId);
    }

    @PostMapping
    public EmailResponse sendEmail(@RequestBody NewEmailRequest emailRequest) {
    	//for now just sending the emailRequest with all fields. Once logins are introduced can reduce the fields that emailRequest accepts and get them from the user jwt.
    	return emailService.saveMedicationRequestEmail(emailRequest.getAlertId());
    }
    
    @GetMapping (path="show-email-content")
    public EmailContentResponse showEmailContent(@RequestParam String id) {
    	return emailService.getLastEmailContent(id);
    }
    
    @GetMapping(path="/resend")
    public EmailResponse tryResendEmail(@RequestParam String id) {
    	return emailService.tryResendEmail(id);
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
    
    @GetMapping(path="/ask-if-ready")
    public ArrayList<EmailResponse> sendAskIfReadyEmails() {
    	return emailService.sendAskIfReadyEmails(1);    	
    }
    
    @PostMapping(path="/ready-for-collection")
    public EmailResponse medicationisReady(@RequestBody MedicationOrderStatusRequest medOrderStatusRequest) {
        return emailService.medicationIsReady(medOrderStatusRequest);
    }
    
    @GetMapping(path="/collected")
    public EmailResponse collectedMedication(@RequestParam String id) {
    	return emailService.markCollected(id);
    }
    
    @GetMapping(path="/undo-collected")
    public EmailResponse undoCollectedMedication(@RequestParam String id) {
    	return emailService.undoMarkCollected(id);
    }
}




