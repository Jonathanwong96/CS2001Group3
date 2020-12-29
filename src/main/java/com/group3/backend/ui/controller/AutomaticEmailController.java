package com.group3.backend.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.service.AutomaticEmailService;
import com.group3.backend.ui.model.request.AutomaticEmailRequest;
import com.group3.backend.ui.model.response.AutomaticEmailResponse;


@RestController
@RequestMapping("auto-email")
public class AutomaticEmailController {

    @Autowired
    AutomaticEmailService automaticEmailService;
    
    @GetMapping
    public AutomaticEmailResponse usesAutomaticEmail(@RequestParam long careHomeId) {
    	return automaticEmailService.getUsesAutomaticEmail(careHomeId);
    }

    @PutMapping
    public AutomaticEmailResponse updateAutomaticEmail(@RequestBody AutomaticEmailRequest autoEmailRequest) {
    	//for now just sending the emailRequest with all fields. Once logins are introduced can reduce the fields that emailRequest accepts and get them from the user jwt.
    	return automaticEmailService.updateAutomaticEmail(autoEmailRequest);
    }
    
    @PostMapping
    public AutomaticEmailResponse createAutomaticEmail(@RequestBody AutomaticEmailRequest autoEmailRequest) {
    	//for now just sending the emailRequest with all fields. Once logins are introduced can reduce the fields that emailRequest accepts and get them from the user jwt.
    	return automaticEmailService.createAutomaticEmail(autoEmailRequest);
    }
	
}
