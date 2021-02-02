package com.group3.backend.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.service.AlertService;
import com.group3.backend.service.EmailService;
import com.group3.backend.ui.model.response.AlertResponse;
import com.group3.backend.ui.model.response.EmailResponse;

@RestController //So we can use GET, POST, PUT methods
@RequestMapping("alerts") //to define the URL. oursite.com/alerts
public class AlertController {
    @Autowired
    AlertService alertService;
    
    @GetMapping
    public ArrayList<AlertResponse> getAllAlerts(@RequestParam long careHomeId) {
    	return alertService.getAllAlertsForCareHome(careHomeId);
    }
}
