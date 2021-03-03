package com.group3.backend.service;

import java.util.ArrayList;
//import java.util.List;
import java.util.Date;

import com.group3.backend.ui.model.request.MedicationAuditRequest;
import com.group3.backend.ui.model.response.MedicationAuditResponse;

public interface MedicationAuditService {
	
	ArrayList<MedicationAuditResponse> getAllAudits(Long medCountId);
	ArrayList<MedicationAuditResponse> getCounts(Date countDoneOnDate);


	MedicationAuditResponse createAudit(MedicationAuditRequest medicationAudit);
	MedicationAuditResponse updateAudit(MedicationAuditRequest medicationAudit);

}
