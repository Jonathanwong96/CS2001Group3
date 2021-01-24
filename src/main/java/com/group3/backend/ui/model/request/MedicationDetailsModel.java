package com.group3.backend.ui.model.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="medication")
public class MedicationDetailsModel {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private String medicationDescription;
	private Integer dosage;
	private Character medicationClass;
	private String medicationName;
	private String pharmacyName;
	private Integer prescriptionCount;
	
	public MedicationDetailsModel() {
		
	}
	public MedicationDetailsModel(String medicationDescription, Integer dosage, Character medicationClass,
			String medicationName, String pharmacyName, Integer prescriptionCount) {
		this.medicationDescription = medicationDescription;
		this.dosage = dosage;
		this.medicationClass = medicationClass;
		this.medicationName = medicationName;
		this.pharmacyName = pharmacyName;
		this.prescriptionCount = prescriptionCount;
	}
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMedicationDescription() {
		return medicationDescription;
	}
	public void setMedicationDescription(String medicationDescription) {
		this.medicationDescription = medicationDescription;
	}
	public Integer getDosage() {
		return dosage;
	}
	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}
	public Character getMedicationClass() {
		return medicationClass;
	}
	public void setMedicationClass(Character medicationClass) {
		this.medicationClass = medicationClass;
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
	public Integer getPrescriptionCount() {
		return prescriptionCount;
	}
	public void setPrescriptionCount(Integer prescriptionCount) {
		this.prescriptionCount = prescriptionCount;
	}

	
	
	
	
}
