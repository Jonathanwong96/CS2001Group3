package com.group3.backend.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.datasource.repos.MedicationRepository;
import com.group3.backend.service.MedicationService;
import com.group3.backend.ui.model.request.MedicationRequest;
import com.group3.backend.ui.model.response.MedicationResponse;

@Service
public class MedicationImpl implements MedicationService{
	
	@Autowired
	MedicationRepository medicationRepository;
	
	@Override
    public List<MedicationEntity> findAll(long Id){
    	
    	return (List<MedicationEntity>) medicationRepository.findAll();
    }
	
	@Override
    public MedicationResponse createMedication(MedicationRequest medicationRequest) {
    	
    	MedicationResponse toReturn = new MedicationResponse();
    	MedicationEntity mediEntity = new MedicationEntity();
        BeanUtils.copyProperties(medicationRequest, mediEntity); //copy from request to the new instance created
        MedicationEntity savedMedication = medicationRepository.save(mediEntity);
        BeanUtils.copyProperties(savedMedication, toReturn);

        return toReturn;
    }
	
	// @Override
	// public MedicationResponse updateMedication(MedicationRequest medicationRequest) {
		
	// 	 	MedicationResponse toReturn = new MedicationResponse();
    //        BeanUtils.copyProperties(updateMedication(medicationRequest), toReturn);
    //        return toReturn;
   	
	// }


}
