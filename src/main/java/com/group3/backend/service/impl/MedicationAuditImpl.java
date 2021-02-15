package com.group3.backend.service.impl;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.repos.MedicationAuditRepository;
import com.group3.backend.service.MedicationAuditService;
import com.group3.backend.ui.model.request.MedicationAuditRequest;
import com.group3.backend.ui.model.response.MedicationAuditResponse;

@Service
public class MedicationAuditImpl implements MedicationAuditService {

	    @Autowired
	    MedicationAuditRepository medicationAuditRepository;

	    @Override
	    public ArrayList<MedicationCountEntity> findAll(){

	    	return (ArrayList<MedicationCountEntity>) medicationAuditRepository.findAll();
	    }

	    @Override
	    public MedicationAuditResponse createAudit(MedicationAuditRequest medicationAuditRequest) {

	    	MedicationAuditResponse toReturn = new MedicationAuditResponse();
	    	MedicationCountEntity auditEntity = new MedicationCountEntity();
	        BeanUtils.copyProperties(medicationAuditRequest, auditEntity); //copy from request to the new instance created
	        MedicationCountEntity savedAudit = medicationAuditRepository.save(auditEntity);
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
