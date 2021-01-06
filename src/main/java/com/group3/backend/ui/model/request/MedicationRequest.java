package com.group3.backend.ui.model.request;

public class MedicationRequest {

	private Long id;
	private String medicationName;
	private Integer prescriptionCount;
	private String description;
	private String dosage;
	private String pharmacyName;
	private String medicationClass;
	
	   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public String getMedicationName() {
    	return medicationName;
    }
    public void setMedicationName(String medicationName) {
    	this.medicationName = medicationName;
    }
    
    public Integer getPrecriptionCount() {
    	return prescriptionCount;
    }
    public void setPrescriptionCount(Integer prescriptionCount) {
    	this.prescriptionCount = prescriptionCount;
    }
  
    public String getDescription() {
    	return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }

    public String getMedicationClass() {
    	return medicationClass;
    }
    public void setMedicationClass(String medicationClass) {
    	this.medicationClass = medicationClass;
    }

    public String getDosage() {
    	return dosage;
    }
    public void setDosage(String dosage) {
    	this.dosage = dosage;
    }

    public String getPharmacyName() {
    	return pharmacyName;
    }
    public void setPharmacyName(String pharmacyName) {
    	this.pharmacyName = pharmacyName;
    }

}
