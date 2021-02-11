package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.ui.model.request.AddMedicationRequest;
import com.group3.backend.ui.model.response.MedicationDoseResponse;
import com.group3.backend.ui.model.response.MedicationForResidentResponse;

public interface MedicationForResidentService {
	MedicationForResidentResponse addMedicationForResident(AddMedicationRequest addMedReq);
	ArrayList<MedicationDoseResponse> getResidentsUpcommingDoses(long residentId);
	ArrayList<MedicationDoseResponse> getUpcommingDosesForAllResidents(long careHomeId);
}
