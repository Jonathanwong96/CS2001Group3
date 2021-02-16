package com.group3.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.entity.ResidentEntity;
import com.group3.backend.datasource.repos.MedicationDetailsRepository;
import com.group3.backend.datasource.repos.MedicationForResidentRepository;
import com.group3.backend.datasource.repos.MedicationRepository;
import com.group3.backend.datasource.repos.ResidentRepository;
import com.group3.backend.service.impl.MedicationCountImpl;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.MedicationDetailsResponse;

@Service
public class MedicationDetailsService {
	/*
	private String description; //MedicationEntity
	private String medicationName; //MedicationEntity
	private ArrayList<MedicationDoseResponse> dosage; //MedicationDoseEntity    ///MedicationDoseResponse you'll have to get from my branch at some point. can just copy it over.
	private String pharmacyName; //MedicationForResident
	private Integer medicationCount; //MedicationCountEntity 
*/
	@Autowired
	private MedicationRepository medRepo;
	@Autowired MedicationForResidentRepository resMedRepo;
    @Autowired 
    private ResidentRepository resRepo;
    
   
  
    

    public MedicationDetailsResponse getPatientMedicationDetails(@RequestParam long medForResId) {
    	Optional<MedicationForResidentEntity> resp = resMedRepo.findById(medForResId);
		if (resp.isEmpty()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
    	} else {
			MedicationForResidentEntity medResEnt = resp.get();
			MedicationEntity medEnt = medResEnt.getMedication();
			MedicationDetailsResponse medRes = new MedicationDetailsResponse();
			
			medRes.setDescription(medEnt.getDescription());
			
			medRes.setMedicationCount(medResEnt.getMedicationCounts().get((int) medForResId).getCount());
			
			
			medRes.setDosage(medRes.getDosage());
			if (medResEnt.getPharmacy() != null) {
				medRes.setPharmacyName(medResEnt.getPharmacy().getName());
			}
			
			medRes.setMedicationName(medEnt.getName());
			return medRes;
		}
    	
    	
        //Create MedicationDetailsResponse.java
        
        //get medForResEntity using the medForResId

        //get MedicationEntity from medForResEntity - description & medicationName

        //get a list of MedicationDoseEntity from medForResEntity - doses

        //get the PharmacyEntity from medForResEntity

        //get the most recent MedicationCountEntity from medForResEntity - medicationCount
        
    }
}
