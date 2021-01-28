package com.group3.backend.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.group3.backend.ui.model.request.MedicationDetailsModel;
import com.group3.backend.ui.model.response.MedicationDetailsRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MedicationDetailsController {
	@Autowired
	private MedicationDetailsRepository medicationDetailsRepo;

	@GetMapping("/medications")
	public List<MedicationDetailsModel> getMedication()
	{
		return medicationDetailsRepo.findAll();
	}
}
