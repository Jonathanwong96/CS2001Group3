package com.group3.backend.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.service.MedicationForResidentService;
import com.group3.backend.service.MedicationService;
import com.group3.backend.ui.model.request.AddMedicationRequest;
import com.group3.backend.ui.model.response.AutomaticEmailResponse;
import com.group3.backend.ui.model.response.MedicationDoseResponse;
import com.group3.backend.ui.model.response.MedicationResponse;
import com.group3.backend.ui.model.response.MedicationForResidentResponse;

@RestController
@RequestMapping("medication")
public class MedicationController {
	
	@Autowired MedicationService medicationService;
	
	@Autowired MedicationForResidentService medicationForResidentService;
	
    @GetMapping
    public ArrayList<MedicationResponse> getMedicationsForCareHome(@RequestParam long careHomeId) {
    	return medicationService.getAllMedicationsForCareHome(careHomeId);
    }
    
    @GetMapping(path="resident")
    public ArrayList<MedicationResponse> getMedicationsForResident(@RequestParam long residentId) {
    	return medicationService.getAllMedicationsForResident(residentId);
    }
    
    @PostMapping
    public MedicationForResidentResponse addMedicationForResident(@RequestBody AddMedicationRequest addMedReq) {
    	return medicationForResidentService.addMedicationForResident(addMedReq);
    }
    
    @GetMapping(path="schedule")
    public ArrayList<MedicationDoseResponse> getResidentsUpcommingDoses(@RequestParam long residentId) {
    	return medicationForResidentService.getResidentsUpcommingDoses(residentId);
    }
    
    @GetMapping(path="/schedule/all")
    public ArrayList<MedicationDoseResponse> getAllUpcommingDosesForCareHome(@RequestParam long careHomeId) {
    	return medicationForResidentService.getUpcommingDosesForAllResidents(careHomeId);
    }
}
