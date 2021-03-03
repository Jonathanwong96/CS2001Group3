package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.MedicationDoseEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.repos.MedicationDoseRepository;
import com.group3.backend.service.MedicationDoseService;
import com.group3.backend.ui.model.request.MedicationDoseRequest;

@Service
public class MedicationDoseImpl implements MedicationDoseService {

	@Autowired MedicationDoseRepository medicationDoseRepository;
	
	public ArrayList<MedicationDoseEntity> addDosesForMedForRes(MedicationForResidentEntity medForResEntity, 
																ArrayList<MedicationDoseRequest> doses) {
		
		ArrayList<MedicationDoseEntity> toSave = new ArrayList<>();
		for (MedicationDoseRequest dose: doses) {
			MedicationDoseEntity medDoseEnt = new MedicationDoseEntity();
			medDoseEnt.setMedicationforResident(medForResEntity);
			medDoseEnt.setDose(dose.getDose());
			medDoseEnt.setRepetition(dose.getRepeats());
			medDoseEnt.setTimeToTake(dose.getTime());
			toSave.add(medDoseEnt);
		}
		Iterable<MedicationDoseEntity> savedEntities = medicationDoseRepository.saveAll(toSave);
		
		ArrayList<MedicationDoseEntity> allSavedDoses = new ArrayList<>();
		savedEntities.forEach(allSavedDoses::add);
		return allSavedDoses;
	}
	
}
