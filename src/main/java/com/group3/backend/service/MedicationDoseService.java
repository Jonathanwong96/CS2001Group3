package com.group3.backend.service;

import java.util.ArrayList;

import com.group3.backend.datasource.entity.MedicationDoseEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.ui.model.request.MedicationDoseRequest;

public interface MedicationDoseService {
	ArrayList<MedicationDoseEntity> addDosesForMedForRes(MedicationForResidentEntity medForResEntity, ArrayList<MedicationDoseRequest> doses);
}
