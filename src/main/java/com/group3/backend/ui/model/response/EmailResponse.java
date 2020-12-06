package com.group3.backend.ui.model.response;

import java.util.Date;

public class EmailResponse {
	private String status;
	private String pharmacyEmail;
	private String residentName;
	private String medicationName;
	private Date dateSent;
	private Date dateUpdatedByPharmacy;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPharmacyEmail() {
		return pharmacyEmail;
	}
	public void setPharmacyEmail(String pharmacyEmail) {
		this.pharmacyEmail = pharmacyEmail;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	public Date getDateUpdatedByPharmacy() {
		return dateUpdatedByPharmacy;
	}
	public void setDateUpdatedByPharmacy(Date dateUpdatedByPharmacy) {
		this.dateUpdatedByPharmacy = dateUpdatedByPharmacy;
	}
	
	
	
	
}
