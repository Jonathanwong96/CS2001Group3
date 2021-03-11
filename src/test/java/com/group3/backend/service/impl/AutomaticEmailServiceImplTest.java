package com.group3.backend.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.group3.backend.datasource.entity.AlertEntity;
import com.group3.backend.datasource.entity.CareHomeEntity;
import com.group3.backend.datasource.entity.EmailEntity;
import com.group3.backend.datasource.entity.MedicationEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.datasource.entity.ResidentEntity;
import com.group3.backend.datasource.repos.AlertRepository;
import com.group3.backend.datasource.repos.CareHomeRepository;
import com.group3.backend.datasource.repos.EmailRepository;
import com.group3.backend.datasource.repos.MedicationForResidentRepository;
import com.group3.backend.datasource.repos.MedicationRepository;
import com.group3.backend.datasource.repos.ResidentRepository;

class AutomaticEmailServiceImplTest {
	private AutomaticEmailServiceImpl automaticEmailServiceImpl = new AutomaticEmailServiceImpl();
	
	@Test
	void canGetOutAlertsForOnlyCareHomesWithAutoEmailEnabled() {
		//adding data. care home with auto alerts enabled
		CareHomeEntity careHomeEnt = new CareHomeEntity();
		careHomeEnt.setUsesAutoEmail(true);
		ResidentEntity resEnt = new ResidentEntity();
		MedicationForResidentEntity medForResEnt = new MedicationForResidentEntity();
		AlertEntity alertEnt = new AlertEntity();
		alertEnt.setDateCreated(new Date(Date.UTC(3000, 1, 1, 10, 10, 10)));
		ArrayList<MedicationForResidentEntity> allMedsForRes = new ArrayList<>();
		allMedsForRes.add(medForResEnt);
		ArrayList<ResidentEntity> allResidents = new ArrayList<>();
		allResidents.add(resEnt);
		ArrayList<AlertEntity> allAlerts = new ArrayList<>();
		allAlerts.add(alertEnt);
		careHomeEnt.setResidents(allResidents);
		resEnt.setAllMedicationsForResident(allMedsForRes);
		medForResEnt.setAlertsForMedication(allAlerts);
		
		
		//no auto alerts enabled
		CareHomeEntity careHomeEnt2 = new CareHomeEntity();
		careHomeEnt2.setUsesAutoEmail(false);
		ResidentEntity resEnt2 = new ResidentEntity();
		MedicationForResidentEntity medForResEnt2 = new MedicationForResidentEntity();
		AlertEntity alertEnt2 = new AlertEntity();
		alertEnt2.setDateCreated(new Date());
		ArrayList<MedicationForResidentEntity> allMedsForRes2 = new ArrayList<>();
		allMedsForRes2.add(medForResEnt2);
		ArrayList<ResidentEntity> allResidents2 = new ArrayList<>();
		allResidents2.add(resEnt2);
		ArrayList<AlertEntity> allAlerts2 = new ArrayList<>();
		allAlerts2.add(alertEnt2);
		careHomeEnt2.setResidents(allResidents2);
		resEnt2.setAllMedicationsForResident(allMedsForRes2);
		medForResEnt2.setAlertsForMedication(allAlerts2);
		
		ArrayList<CareHomeEntity> careHomes = new ArrayList<>();
		careHomes.add(careHomeEnt2); careHomes.add(careHomeEnt);
		
		ArrayList<AlertEntity> calcedAlerts = automaticEmailServiceImpl.getAllAlertsToSendFromCareHomes(careHomes);
		assertEquals(1, calcedAlerts.size());
		assertEquals(3000, calcedAlerts.get(0).getDateCreated().getYear());
	}
	
	@Test
	void doesntGetOutAlertsIfEmailAlreadySent() {
		//adding data. care home with auto alerts enabled
		CareHomeEntity careHomeEnt = new CareHomeEntity();
		careHomeEnt.setUsesAutoEmail(true);
		ResidentEntity resEnt = new ResidentEntity();
		MedicationForResidentEntity medForResEnt = new MedicationForResidentEntity();
		AlertEntity alertEnt = new AlertEntity();
		alertEnt.setDateCreated(new Date(Date.UTC(3000, 1, 1, 10, 10, 10)));
		AlertEntity oldAlert = new AlertEntity();
		oldAlert.setDateCreated(new Date(Date.UTC(1111, 1, 1, 10, 10, 10)));
		EmailEntity email = new EmailEntity();
		oldAlert.setEmail(email);
		ArrayList<MedicationForResidentEntity> allMedsForRes = new ArrayList<>();
		allMedsForRes.add(medForResEnt);
		ArrayList<ResidentEntity> allResidents = new ArrayList<>();
		allResidents.add(resEnt);
		ArrayList<AlertEntity> allAlerts = new ArrayList<>();
		allAlerts.add(alertEnt); allAlerts.add(oldAlert);
		careHomeEnt.setResidents(allResidents);
		resEnt.setAllMedicationsForResident(allMedsForRes);
		medForResEnt.setAlertsForMedication(allAlerts);
		
		ArrayList<CareHomeEntity> careHomes = new ArrayList<>();
		careHomes.add(careHomeEnt);
		
		ArrayList<AlertEntity> calcedAlerts = automaticEmailServiceImpl.getAllAlertsToSendFromCareHomes(careHomes);
		assertEquals(1, calcedAlerts.size());
		assertEquals(3000, calcedAlerts.get(0).getDateCreated().getYear());
	}

}
