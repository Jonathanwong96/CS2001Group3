package com.group3.backend.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group3.backend.service.CareWorkerService;
import com.group3.backend.ui.model.request.CareWorkerRequest;
import com.group3.backend.ui.model.response.CareWorkerResponse;

@RestController
@RequestMapping("careWorker")
public class CareWorkerController {
	
	@Autowired
	CareWorkerService careWorkerService;
	
	@PostMapping
	public CareWorkerResponse addCareWorker(@RequestBody CareWorkerRequest careWorkerRequest) {
		return careWorkerService.createCareWorker(careWorkerRequest);
	}
	
	@PutMapping
	public CareWorkerResponse editCareWorker(@RequestBody CareWorkerRequest careWorkerRequest) {
		
		return careWorkerService.editCareWorker(careWorkerRequest);
	}
	
	@DeleteMapping(produces="application/json")
	public Object deleteCareWorker(@RequestParam long careWorkerId) {
		return careWorkerService.deleteCareWorker(careWorkerId);
	}
	
	@GetMapping(path="all")
    public ArrayList<CareWorkerResponse> getAllCareWorkersForHome(@RequestParam long careHomeId) {
        return careWorkerService.getAllCareWorkersForHome(careHomeId);
    }
	
	@GetMapping
	public CareWorkerResponse getCareWorker(@RequestParam long careWorkerId) {
		return careWorkerService.getCareWorker(careWorkerId);
	}
	
}