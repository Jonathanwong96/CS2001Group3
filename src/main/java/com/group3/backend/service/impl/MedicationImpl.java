package com.group3.backend.service.impl;


import java.util.List;

import org.springframework.beans.BeanUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.datasource.repos.MedicationForResidentRepository;
import com.group3.backend.datasource.repos.MedicationRepository;
import com.group3.backend.service.MedicationService;
import com.group3.backend.ui.model.request.MedicationRequest;
import com.group3.backend.ui.model.response.MedicationResponse;


import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.repos.MedicationRepository;
import com.group3.backend.service.MedicationService;
import com.group3.backend.ui.model.response.MedicationResponse;

@Service
public class MedicationImpl implements MedicationService {
	
	@Autowired MedicationRepository medicationRepository;
	@Autowired MedicationForResidentRepository medForResRepository;

	public ArrayList<MedicationResponse> getAllMedicationsForCareHome(long careHomeId) {
		ArrayList<MedicationResponse> allMedsForCareHome = new ArrayList<>();
		
		Iterator<MedicationEntity> allMeds = medicationRepository.findAll().iterator();
		while(allMeds.hasNext()) {
			MedicationEntity med = allMeds.next();
			List<MedicationForResidentEntity> allMedicationsForResidents = med.getAllResidentsForMedication();
			for (MedicationForResidentEntity medForMes: allMedicationsForResidents) {
				if (medForMes.getResident().getCareHome().getCareHomeId() == careHomeId) {
					MedicationResponse medResponse = new MedicationResponse();
					medResponse.setName(med.getName());
					medResponse.setDescription(med.getDescription());
					medResponse.setMedicationId(med.getMedicationId());
					allMedsForCareHome.add(medResponse);
					break; //only want to add the medication once. So if one resident at a care home is using the med we can add it.
				}
			}
		}
		return allMedsForCareHome;
	}
	
	
	public MedicationEntity addMedication(String name, String desc) {
		MedicationEntity medEntity = new MedicationEntity();
		medEntity.setName(name);
		medEntity.setDescription(desc);
		return medicationRepository.save(medEntity);
	}


	@Override
	public ArrayList<MedicationResponse> getAllMedicationsForResident(long residentId) {
		ArrayList<MedicationResponse> allMedsForResident = new ArrayList<>();
		
		ArrayList<MedicationForResidentEntity> medsForRes = medForResRepository.findAllByResidentResidentId(residentId);
		for (MedicationForResidentEntity med: medsForRes) {
			MedicationResponse medResp = new MedicationResponse();
			MedicationEntity medEnt = new MedicationEntity();
			medResp.setMedicationName(med.getMedication().getName());
			medResp.setId(med.getId());
			medResp.setDescription("This id is for the Medication for resident entity - " + med.getId());
			allMedsForResident.add(medResp);
		}
		return allMedsForResident;
	}
	
}
