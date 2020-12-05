package com.group3.backend.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.service.ResidentService;
import com.group3.backend.ui.model.request.ResidentRequest;
import com.group3.backend.ui.model.response.ResidentResponse;

@RestController
@RequestMapping("resident")
public class ResidentController {
	
	@Autowired
	ResidentService residentService;
	
	//overwrites resident entity if it already exists(should we limit it to only create new?) - SK
	@PostMapping
	public ResidentResponse addResident(@RequestBody ResidentRequest residentRequest) {
		return residentService.createResident(residentRequest);
	}
	
	@PutMapping
	public ResidentResponse editResident(@RequestBody ResidentRequest residentRequest) {
		return residentService.editResident(residentRequest);
	}
	

}
