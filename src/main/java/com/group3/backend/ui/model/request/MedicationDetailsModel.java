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
	
	private String description;
	private String dosage;
	private Character medicationClass;
	private String medicationName;
	private String pharmacyName;
	private Integer prescriptionCount;
	
	public MedicationDetailsModel() {
		
	}
	public MedicationDetailsModel(String medicationDescription, String dosage, Character medicationClass,
			String medicationName, String pharmacyName, Integer prescriptionCount) {
		this.description = medicationDescription;
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
		return description;
	}
	public void setMedicationDescription(String medicationDescription) {
		this.description = medicationDescription;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
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
