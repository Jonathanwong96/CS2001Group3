package com.group3.backend.ui.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.group3.backend.datasource.entity.MedicationAuditEntity;
import com.group3.backend.datasource.entity.MedicationCountEntity;
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

	@PostMapping(path = "/updateAudit") // put mapping instead??
	public MedicationAuditResponse updateAudit(@RequestBody MedicationAuditRequest medicationAuditRequest) {

		return MedicationAuditService.updateAudit(medicationAuditRequest);
	}

	@GetMapping(path = "/viewAll")
	public ArrayList<MedicationCountEntity> findAll(@RequestParam Date countDoneOnDate) {

		return MedicationAuditService.findAll();
	}
	}
