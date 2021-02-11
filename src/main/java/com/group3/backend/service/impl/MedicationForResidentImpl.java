package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.group3.backend.datasource.entity.MedicationDoseEntity;
import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.entity.PharmacyEntity;
import com.group3.backend.datasource.entity.ResidentEntity;
import com.group3.backend.datasource.repos.MedicationForResidentRepository;
import com.group3.backend.datasource.repos.MedicationRepository;
import com.group3.backend.datasource.repos.PharmacyRepository;
import com.group3.backend.datasource.repos.ResidentRepository;
import com.group3.backend.service.MedicationDoseService;
import com.group3.backend.service.MedicationForResidentService;
import com.group3.backend.service.MedicationService;
import com.group3.backend.service.helper.DateHelper;
import com.group3.backend.ui.model.request.AddMedicationRequest;
import com.group3.backend.ui.model.response.ErrorMessages;
import com.group3.backend.ui.model.response.MedicationDoseResponse;
import com.group3.backend.ui.model.response.MedicationForResidentResponse;

@Service
public class MedicationForResidentImpl implements MedicationForResidentService {
	
	@Autowired MedicationService medicationService;
	
	@Autowired MedicationDoseService medicationDoseService;
	
	@Autowired MedicationRepository medicationRepository;
	
	@Autowired ResidentRepository residentRepository;
	
	@Autowired MedicationForResidentRepository medicationForResidentRepository;
	
	@Autowired PharmacyRepository pharmacyRepository;
	
	public MedicationForResidentResponse addMedicationForResident(AddMedicationRequest addMedReq) {
		MedicationEntity medEntity;
		if (addMedReq.getMedId() == -1) {
			//then we don't have a medication added and need to add that to the db before proceeding.
			medEntity = medicationService.addMedication(addMedReq.getMedName(), addMedReq.getMedDesc());
		} else {
			//it's in the db - let's get it out.
			Optional<MedicationEntity> medResult = medicationRepository.findById(addMedReq.getMedId());
			if (medResult.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
			} else {
				medEntity = medResult.get();
			}
		}
		
		//now need to get resident out of the db
		Optional<ResidentEntity> resResult = residentRepository.findById(addMedReq.getResId());
		if (resResult.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		}
		ResidentEntity resEntity= resResult.get();
		
		//finally get pharmacy out of the db
		Optional<PharmacyEntity> pharResult = pharmacyRepository.findById(addMedReq.getPharmacyId());
		if (resResult.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessages.COULD_NOT_FIND.getErrorMessage());
		}
		PharmacyEntity pharEntity= pharResult.get();
		
		MedicationForResidentEntity medForResEntity = new MedicationForResidentEntity();
		medForResEntity.setMedication(medEntity);
		medForResEntity.setResident(resEntity);
		medForResEntity.setPharmacy(pharEntity);
		MedicationForResidentEntity savedEntity = medicationForResidentRepository.save(medForResEntity);
		
		//need to add the doses
		medicationDoseService.addDosesForMedForRes(savedEntity, addMedReq.getMedDoses());
		
		MedicationForResidentResponse medForResResp = new MedicationForResidentResponse();
		medForResResp.setMedicationId(medEntity.getMedicationId());
		medForResResp.setResidentId(resEntity.getResidentId());
		return medForResResp;
	}


	public ArrayList<MedicationDoseResponse> getResidentsUpcommingDoses(long residentId) {
		ArrayList<MedicationDoseResponse> allUpcommingDoses = new ArrayList<>();
		
		ArrayList<MedicationForResidentEntity> allMedForRes = medicationForResidentRepository.findAllByResidentResidentId(residentId);
		for (MedicationForResidentEntity medForRes: allMedForRes) {
			List<MedicationDoseEntity> medDoses = medForRes.getMedicationDoses();
			for (MedicationDoseEntity dose: medDoses) {
				Date nextDue = findFirstDateTodayOrLater(dose);
				dose.setTimeToTake(nextDue); //so that next time we try this we don't have to add days from when the original record was added.
				
				MedicationDoseResponse medDoseResp = new MedicationDoseResponse();
				medDoseResp.setDose(dose.getDose());
				medDoseResp.setMedicationName(medForRes.getMedication().getName());
				medDoseResp.setResidentId(residentId);
				medDoseResp.setTime(nextDue);
				medDoseResp.setRepeats(dose.getRepetition());
				allUpcommingDoses.add(medDoseResp);
			}
		}
		return allUpcommingDoses;
	}
	
	public ArrayList<MedicationDoseResponse> getUpcommingDosesForAllResidents(long careHomeId) {
		//find all residents for a care home
		List<ResidentEntity> allResidentsForCareHome = residentRepository.findByCareHomeCareHomeId(careHomeId);
		ArrayList<MedicationDoseResponse> allUpcommingDoses = new ArrayList<>();
		
		for (ResidentEntity res: allResidentsForCareHome) {
			ArrayList<MedicationDoseResponse> allUpcommingForRes = getResidentsUpcommingDoses(res.getResidentId());
			allUpcommingDoses.addAll(allUpcommingForRes);
		}
		
		return allUpcommingDoses;
	}
	
	
	private Date findFirstDateTodayOrLater(MedicationDoseEntity medDose) {
		Date startOfToday = DateHelper.getStartOfDayXDaysInAdvance(0);
		Date todayOrLater = medDose.getTimeToTake(); 
		
		int daysToAdd;
		if (medDose.getRepetition().equals("Every day")) {
			daysToAdd = 1;
		} else if (medDose.getRepetition().equals("Every 2 days")) {
			daysToAdd = 2;
		} else if (medDose.getRepetition().equals("Every 3 days")) {
			daysToAdd = 3;
		} else {
			daysToAdd = 7;
		}
		while (todayOrLater.before(startOfToday)) {
			todayOrLater = DateHelper.addDays(medDose.getTimeToTake(), daysToAdd);
		}
		return todayOrLater;
	}
	
	
	
	

}
