package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.service.helper.DateHelper;
import com.group3.backend.service.helper.EmailStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.backend.datasource.entity.AlertEntity;
import com.group3.backend.datasource.repos.AlertRepository;
import com.group3.backend.datasource.repos.EmailRepository;
import com.group3.backend.service.AlertService;
import com.group3.backend.service.MedicationCountService;
import com.group3.backend.ui.model.response.AlertResponse;

import com.group3.backend.datasource.entity.MedicationCountEntity;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired private AlertRepository alertRepository;
    
    @Autowired private MedicationCountService medicationCountService;

	public ArrayList<AlertResponse> getAllAlertsForCareHome(long careHomeId) {
		ArrayList<AlertResponse> alertsForCareHome = new ArrayList<>();
		
		alertRepository.findAll().forEach(alert -> {
			if (alert.getMedForResident().getResident().getCareHome().getCareHomeId() == careHomeId &&
				alert.getEmail() == null
			) {
				AlertResponse alertResp = new AlertResponse();
				alertResp.setAlertId(alert.getId());
				alertResp.setMedicationName(alert.getMedForResident().getMedication().getName());
				alertResp.setResidentName(alert.getMedForResident().getResident().getFullName());
				alertResp.setCycleEndDate(alert.getPredictedEndDate());
				alertResp.setPharmacyEmail(alert.getMedForResident().getPharmacy().getEmail());
				alertsForCareHome.add(alertResp);
			}
		});
		
		return alertsForCareHome;
	}

	@Override
	public AlertEntity createAlert(MedicationCountEntity mce) {
		//needs to make sure that if there is an email or an alert within the last 30 days.
		MedicationForResidentEntity medForResEntity = mce.getMedicationForResident();
		ArrayList<AlertEntity> alerts = new ArrayList<>(medForResEntity.getAlertsForMedication());
		boolean alertExists = false;
		for (AlertEntity alertInDb: alerts) {
			if (DateHelper.findDaysBetween(new Date(), alertInDb.getDateCreated()) < 30 &&
					(alertInDb.getEmail() == null || !alertInDb.getEmail().getStatus().equals(EmailStatus.COMPLETED.getMessage()))) {
				alertExists = true;
				break;
			}
		}
		if (!alertExists) {
			AlertEntity alert = new AlertEntity();
			alert.setDateCreated(new Date());
			alert.setMedForResident(mce.getMedicationForResident());
			alert.setPredictedEndDate(mce.getCyclePredictedToEndOn());
			AlertEntity savedAlert = alertRepository.save(alert);
			return savedAlert;
		}
		return null;
	}


}
