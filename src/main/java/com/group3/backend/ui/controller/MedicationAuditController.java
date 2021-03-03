package com.group3.backend.ui.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.group3.backend.service.impl.MedicationAuditImpl;
import com.group3.backend.ui.model.request.MedicationAuditRequest;
import com.group3.backend.ui.model.response.MedicationAuditResponse;

@RestController
// @RequestMapping(path = "/medicationAudit")
public class MedicationAuditController {

	@Autowired
	MedicationAuditImpl MedicationAuditService;

	@PostMapping(path = "/addAudit") // post mapping instead???
	public MedicationAuditResponse createAudit(@RequestBody MedicationAuditRequest medicationAuditRequest) {

		return MedicationAuditService.createAudit(medicationAuditRequest);
	}

	@RequestMapping(path = "/")
	public String sayHi() {
		return "Trying and testing";
	}

	@PutMapping(path = "/updateAudit") // put mapping instead??
	public MedicationAuditResponse updateAudit(@RequestBody MedicationAuditRequest medicationAuditRequest) {

		return MedicationAuditService.updateAudit(medicationAuditRequest);
	}

	@GetMapping(path ="/show")
	public ArrayList<MedicationAuditResponse> getAllAudits(@RequestParam(value = "medCountId") long medCountId) {
		//return arraylist of medication audit response
		
		return MedicationAuditService.getAllAudits(medCountId);
	}

	@GetMapping(path ="/showCount")
	public ArrayList<MedicationAuditResponse> getCounts(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date countDoneOnDate) {
	
		return MedicationAuditService.getCounts(countDoneOnDate);
	}

	}
