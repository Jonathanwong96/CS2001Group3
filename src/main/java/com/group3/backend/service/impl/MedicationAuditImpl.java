package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.MedicationAuditEntity;
import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.repos.MedicationAuditRepository;
import com.group3.backend.datasource.repos.MedicationCountRepository;
//import com.group3.backend.datasource.repos.MedicationCountRepository;
import com.group3.backend.service.MedicationAuditService;
import com.group3.backend.ui.model.request.MedicationAuditRequest;
import com.group3.backend.ui.model.response.MedicationAuditResponse;

@Service
public class MedicationAuditImpl implements MedicationAuditService {

	    
		@Autowired 
//		MedicationAuditRepository medicationAuditRepository;
		MedicationCountRepository medicationCountRepository;

		@Override
	    public ArrayList<MedicationAuditResponse> getAllAudits(Long medCountId){
			//loop which turns each instance into the data i want to retreive
			//or
			//use beansUtils 
			ArrayList<MedicationAuditResponse> toReturn = new ArrayList<>();
			List<MedicationCountEntity> allAuditsForRes = medicationCountRepository.findAllByMedCountId(medCountId);
			for (MedicationCountEntity mEntity: allAuditsForRes) {
				MedicationAuditResponse mResponse = new MedicationAuditResponse();
				BeanUtils.copyProperties(mEntity, mResponse);
				toReturn.add(mResponse);
			}

	    	return toReturn;
	    }

		// @Override
	    // public ArrayList<MedicationAuditResponse> getAuditDay(Date countDoneOnDate, long medCountId){
		// 	ArrayList<MedicationAuditResponse> toReturn = new ArrayList<>();
		// 	List<MedicationCountEntity> allDatesForAudits = medicationCountRepository.findByDate(countDoneOnDate, medCountId);
		// 	for (MedicationCountEntity mEntity: allDatesForAudits) {
		// 		MedicationAuditResponse mResponse = new MedicationAuditResponse();
		// 		BeanUtils.copyProperties(mEntity, mResponse);
		// 		toReturn.add(mResponse);
		// 	}

	    // 	return toReturn;
	    // }


	    @Override
	    public MedicationAuditResponse createAudit(MedicationAuditRequest medicationAuditRequest) {

	    	MedicationAuditResponse toReturn = new MedicationAuditResponse();
	    	MedicationCountEntity auditEntity = new MedicationCountEntity();
	        BeanUtils.copyProperties(medicationAuditRequest, auditEntity); //copy from request to the new instance created
	        MedicationCountEntity savedAudit = medicationCountRepository.save(auditEntity);
	        BeanUtils.copyProperties(savedAudit, toReturn);

	        return toReturn;
	    }

		@Override
		public MedicationAuditResponse updateAudit(MedicationAuditRequest medicationAuditRequest) {

			// 	MedicationAuditRepository
			 	MedicationAuditResponse toReturn = new MedicationAuditResponse();
	            BeanUtils.copyProperties(updateAudit(medicationAuditRequest), toReturn);
	            return toReturn;

		}


	

}
