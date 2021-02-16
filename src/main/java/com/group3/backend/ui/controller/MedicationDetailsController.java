package com.group3.backend.ui.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.entity.ResidentEntity;
import com.group3.backend.datasource.repos.MedicationDetailsRepository;
import com.group3.backend.datasource.repos.ResidentRepository;
import com.group3.backend.service.MedicationDetailsService;
import com.group3.backend.ui.model.response.MedicationDetailsResponse;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MedicationDetailsController {
	@Autowired
	private MedicationDetailsRepository medicationDetailsRepo;
	
	
	MedicationEntity med;
	@Autowired
	private ResidentRepository resRepo;
	
	
	@Autowired
	private MedicationDetailsService medService;

	@GetMapping("/medications")
	public List<MedicationEntity> getMedication()
	{
		return medicationDetailsRepo.findAll();
	}
	
	
	
	
	

	@GetMapping("/medications/residents")
	public MedicationDetailsResponse getResidentMeds(@RequestParam long medForResId){
		return medService.getPatientMedicationDetails(medForResId);

//		ResidentEntity resEnt = resRepo.findById(id).get();
		//if (resEnt != null) {
		//	
		//	return ResponseEntity.ok(
		//		Arrays.asList(medService.getPatientMedicationDetails(id)));
		//}
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
//
//	@GetMapping("/test")
//	public ResponseEntity<?> test(){
//		HashMap<String, Integer> testmap = new HashMap();
//		testmap.put("test", 0);
//		testmap.put("test2", 1);
//		ArrayList<Object> arr = new ArrayList<>();
//		arr.add(testmap);
//		return ResponseEntity.ok(arr);
//	} 
}
