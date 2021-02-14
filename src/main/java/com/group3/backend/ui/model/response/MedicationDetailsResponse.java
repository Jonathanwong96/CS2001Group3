package com.group3.backend.ui.model.response;


public class MedicationDetailsResponse {
	
	private String description; 
	private String medicationName; 
	//private ArrayList<MedicationDoseResponse> dosage; //MedicationDoseEntity    ///MedicationDoseResponse you'll have to get from my branch at some point. can just copy it over.
	private String pharmacyName; 
	private Integer medicationCount; 
	
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
	public Integer getMedicationCount() {
		return medicationCount;
	}
	public void setMedicationCount(Integer medicationCount) {
		this.medicationCount = medicationCount;
	}
	
}