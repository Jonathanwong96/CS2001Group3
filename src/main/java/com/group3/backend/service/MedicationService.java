package com.group3.backend.service;

import java.util.List;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.ui.model.request.MedicationRequest;
import com.group3.backend.ui.model.response.MedicationResponse;

import java.util.ArrayList;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.ui.model.response.MedicationResponse;

public interface MedicationService {
	ArrayList<MedicationResponse> getAllMedicationsForCareHome(long careHomeId);
	ArrayList<MedicationResponse> getAllMedicationsForResident(long residentId);
	MedicationEntity addMedication(String name, String desc);
}
