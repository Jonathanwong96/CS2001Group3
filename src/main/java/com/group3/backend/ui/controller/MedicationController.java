package com.group3.backend.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.service.impl.MedicationImpl;
import com.group3.backend.ui.model.request.MedicationRequest;
import com.group3.backend.ui.model.response.MedicationResponse;


@RestController
public class MedicationController {
	
	@Autowired
	MedicationImpl MedicationService;
	
	@PostMapping(path = "/addMedication") //post mapping instead???
	public MedicationResponse addMedication(@RequestBody MedicationRequest medicationRequest) {
		
		return MedicationService.addMedication(medicationRequest);
	}

//	@PutMapping(path = "/updateMedication") //put mapping instead??
//	public MedicationResponse updateMedication(@RequestBody MedicationRequest medicationRequest) {
//		
//		return MedicationService.updateMedication(medicationRequest);
//	}

	@GetMapping(path = "/medication")
	public List<MedicationEntity> findAll(@RequestParam long Id){
		
		return MedicationService.findAll(Id);
	}
	
}
