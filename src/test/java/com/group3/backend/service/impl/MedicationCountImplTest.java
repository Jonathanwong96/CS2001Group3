package com.group3.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.entity.MedicationForResidentEntity;
import com.group3.backend.service.helper.DateHelper;


public class MedicationCountImplTest {

	private static MedicationCountImpl medicationCountService;
	
	@Test
	public static void canGetPredictedEndDate() {
		MedicationForResidentEntity mForResEnt = new MedicationForResidentEntity();
		MedicationCountEntity medCountEnt = new MedicationCountEntity();
		medCountEnt.setCountDoneOnDate(DateHelper.getStartOfDayXDaysInAdvance(-2)); //2 days ago
		medCountEnt.setCount(15);
		medCountEnt.setMorningCount(true);
		MedicationCountEntity mostRecentMedCountEnt = new MedicationCountEntity();
		medCountEnt.setCountDoneOnDate(DateHelper.getStartOfDayXDaysInAdvance(-1)); //1 day ago
		medCountEnt.setCount(14);
		medCountEnt.setMorningCount(true);
		ArrayList<MedicationCountEntity> medCounts = new ArrayList<>();
		medCounts.add(medCountEnt);
		medCounts.add(mostRecentMedCountEnt);
		mForResEnt.setMedicationCounts(medCounts);
		
		Date endDate = medicationCountService.getPredictedEndDate(mForResEnt, 13, true);
		int daysInAdvance = DateHelper.findDaysBetween(new Date(), endDate);
		assertEquals(13, daysInAdvance);
	}
	
	@Test
	public static void returnsNullIfNoData() {
		MedicationForResidentEntity mForResEnt = new MedicationForResidentEntity();
		ArrayList<MedicationCountEntity> medCounts = new ArrayList<>();
		mForResEnt.setMedicationCounts(medCounts);
		
		Date endDate = medicationCountService.getPredictedEndDate(mForResEnt, 13, true);
		assertNull(endDate);
	}
	
	@Test
	public static void returnsNullIfNoCountForTime() { 
		//we only compare times done at the same time of day as that makes the calculation easier - we can assume there is 1 day between each reading
		MedicationForResidentEntity mForResEnt = new MedicationForResidentEntity();
		MedicationCountEntity medCountEnt = new MedicationCountEntity();
		medCountEnt.setCountDoneOnDate(DateHelper.getStartOfDayXDaysInAdvance(-2)); //2 days ago
		medCountEnt.setCount(15);
		medCountEnt.setMorningCount(true);
		MedicationCountEntity mostRecentMedCountEnt = new MedicationCountEntity();
		medCountEnt.setCountDoneOnDate(DateHelper.getStartOfDayXDaysInAdvance(-1)); //1 day ago
		medCountEnt.setCount(14);
		medCountEnt.setMorningCount(true);
		ArrayList<MedicationCountEntity> medCounts = new ArrayList<>();
		medCounts.add(medCountEnt);
		medCounts.add(mostRecentMedCountEnt);
		mForResEnt.setMedicationCounts(medCounts);
		
		Date endDate = medicationCountService.getPredictedEndDate(mForResEnt, 13, false);
		assertNull(endDate);
	}
	
	@Test
	public static void returnsNullIfWeveJustIncreasedStock() {
		MedicationForResidentEntity mForResEnt = new MedicationForResidentEntity();
		MedicationCountEntity mostRecentMedCountEnt = new MedicationCountEntity();
		mostRecentMedCountEnt.setCountDoneOnDate(DateHelper.getStartOfDayXDaysInAdvance(-1)); //1 day ago
		mostRecentMedCountEnt.setCount(14);
		mostRecentMedCountEnt.setMorningCount(true);
		ArrayList<MedicationCountEntity> medCounts = new ArrayList<>();
		medCounts.add(mostRecentMedCountEnt);
		mForResEnt.setMedicationCounts(medCounts);
		
		Date endDate = medicationCountService.getPredictedEndDate(mForResEnt, 50, true);
		assertNull(endDate);
	}
	
	@Test
	public static void returnsNullIfNoChangeInStock() {
		MedicationForResidentEntity mForResEnt = new MedicationForResidentEntity();
		MedicationCountEntity mostRecentMedCountEnt = new MedicationCountEntity();
		mostRecentMedCountEnt.setCountDoneOnDate(DateHelper.getStartOfDayXDaysInAdvance(-1)); //1 day ago
		mostRecentMedCountEnt.setCount(14);
		mostRecentMedCountEnt.setMorningCount(true);
		ArrayList<MedicationCountEntity> medCounts = new ArrayList<>();
		medCounts.add(mostRecentMedCountEnt);
		mForResEnt.setMedicationCounts(medCounts);
		
		Date endDate = medicationCountService.getPredictedEndDate(mForResEnt, 14, true);
		assertNull(endDate);
	}
}
