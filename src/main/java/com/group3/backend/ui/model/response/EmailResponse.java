package com.group3.backend.ui.model.response;

import java.util.Date;

public class EmailResponse {
	private String status;
	private String pharmacyEmail;
	private String residentName;
	private String medicationName;
    private Date dateRequested;
    private Date dateLastEmailSent;
    private Date dateUpdatedByPharmacy;
    private Date dateMedicationToBeReady;
    private String pharmacyComment;
	
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
	public Date getDateUpdatedByPharmacy() {
		return dateUpdatedByPharmacy;
	}
	public void setDateUpdatedByPharmacy(Date dateUpdatedByPharmacy) {
		this.dateUpdatedByPharmacy = dateUpdatedByPharmacy;
	}
	public Date getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	public Date getDateLastEmailSent() {
		return dateLastEmailSent;
	}
	public void setDateLastEmailSent(Date dateLastEmailSent) {
		this.dateLastEmailSent = dateLastEmailSent;
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
