package com.group3.backend.ui.model.response;

import java.util.Date;

public class EmailStatusResponse {
	private String careHomeName;
	private String residentName;
	private String medicationName;
	private Date dateMedicationToBeReady;
	private String pharmacyComment;
	
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getCareHomeName() {
		return careHomeName;
	}
	public void setCareHomeName(String careHomeName) {
		this.careHomeName = careHomeName;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public Date getDateMedicationToBeReady() {
		return dateMedicationToBeReady;
	}
	public void setDateMedicationToBeReady(Date dateMedicationToBeReady) {
		this.dateMedicationToBeReady = dateMedicationToBeReady;
	}
	public String getPharmacyComment() {
		return pharmacyComment;
	}
	public void setPharmacyComment(String pharmacyComment) {
		this.pharmacyComment = pharmacyComment;
	}

}
