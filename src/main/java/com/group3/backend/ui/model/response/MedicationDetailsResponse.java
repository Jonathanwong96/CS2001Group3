package com.group3.backend.ui.model.response;

import java.util.ArrayList;
import java.util.List;

import com.group3.backend.datasource.entity.MedicationCountEntity;
import com.group3.backend.datasource.entity.MedicationDoseEntity;

public class MedicationDetailsResponse {
	
	private String description; 
	private String medicationName; 
	private List<MedicationDoseEntity> dosage; //MedicationDoseEntity    ///MedicationDoseResponse you'll have to get from my branch at some point. can just copy it over.
	private String pharmacyName; 
	private int medicationCount; 
	public List<MedicationDoseEntity> getDosage() {
		return dosage;
	}
	public void setDosage(List<MedicationDoseEntity> list) {
		this.dosage = list;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public int getMedicationCount() {
		return medicationCount;
	}
	public void setMedicationCount(int i) {
		this.medicationCount = i;
	}
	
	
}