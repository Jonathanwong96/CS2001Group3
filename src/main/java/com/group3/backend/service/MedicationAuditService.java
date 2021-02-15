package com.group3.backend.service;

import java.util.ArrayList;
//import java.util.List;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.ui.model.request.MedicationAuditRequest;
import com.group3.backend.ui.model.response.MedicationAuditResponse;

public interface MedicationAuditService {

	ArrayList<MedicationCountEntity> findAll();

	MedicationAuditResponse createAudit(MedicationAuditRequest medicationAudit);
	MedicationAuditResponse updateAudit(MedicationAuditRequest medicationAudit);

}
