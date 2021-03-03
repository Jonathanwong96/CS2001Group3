package com.group3.backend.ui.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.service.MedicationCountService;
import com.group3.backend.ui.model.request.MedicationCountRequest;
import com.group3.backend.ui.model.response.MedicationCountResponse;

@RestController
 @RequestMapping(path = "/medicationcounts")
public class MedicationCountController {

	@Autowired
	MedicationCountService medicationCountService;

	@PostMapping(path = "/add")
	public MedicationCountResponse addCount(@RequestBody MedicationCountRequest medicationCountRequest) {
		return medicationCountService.addCount(medicationCountRequest);
	}

//	@PutMapping(path = "/edit") // put mapping instead??
//	public MedicationAuditResponse updateAudit(@RequestBody MedicationAuditRequest medicationAuditRequest) {
//
//		return medicationCountService.updateAudit(medicationAuditRequest);
//	}

	@GetMapping
	public ArrayList<MedicationCountResponse> getAuditsForResident(@RequestParam Long resId) {
		return medicationCountService.getCountsForResident(resId);
	}
	
	}
