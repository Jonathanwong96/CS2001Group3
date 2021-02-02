package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.AlertEntity;
import com.group3.backend.datasource.repos.AlertRepository;
import com.group3.backend.datasource.repos.EmailRepository;
import com.group3.backend.service.AlertService;
import com.group3.backend.service.MedicationCount;
import com.group3.backend.ui.model.response.AlertResponse;

import com.group3.backend.datasource.entity.MedicationCountEntity;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired private AlertRepository alertRepository;
    
    @Autowired private MedicationCount medicationCount;

	public ArrayList<AlertResponse> getAllAlertsForCareHome(long careHomeId) {
		ArrayList<AlertResponse> alertsForCareHome = new ArrayList<>();
		
		alertRepository.findAll().forEach(alert -> {
			if (alert.getMedForResident().getResident().getCareHome().getCareHomeId() == careHomeId) {
				AlertResponse alertResp = new AlertResponse();
				alertResp.setAlertId(alert.getId());
				alertResp.setMedicationName(alert.getMedForResident().getMedication().getName());
				alertResp.setResidentName(alert.getMedForResident().getResident().getFullName());
				
				//now need to get out the most recent estimate of the count for this medication
				List<MedicationCountEntity> allCounts = alert.getMedForResident().getMedicationCounts();
				MedicationCountEntity mostRecentCount = medicationCount.getMostRecentCount(allCounts);
				alertResp.setCycleEndDate(mostRecentCount.getCyclePredictedToEndOn());
				
				alertsForCareHome.add(alertResp);
			}
		});
		
		return alertsForCareHome;
	}
	

}
