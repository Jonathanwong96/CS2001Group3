package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.ui.model.response.MedicationResponse;

public interface MedicationService {
	ArrayList<MedicationResponse> getAllMedicationsForCareHome(long careHomeId);
	MedicationEntity addMedication(String name, String desc);
}
