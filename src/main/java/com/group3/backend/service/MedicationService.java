package com.group3.backend.service;

import java.util.List;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.ui.model.request.MedicationRequest;
import com.group3.backend.ui.model.response.MedicationResponse;



public interface MedicationService {
	
	List<MedicationEntity> findAll(long Id);
	MedicationResponse createMedication(MedicationRequest medication);

//	MedicationResponse updateMedication(MedicationRequest medicationLog);

}
