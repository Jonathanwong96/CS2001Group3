package com.group3.backend.ui.model.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmailRequest {
	private String usersEmail;
	private String usersName;
	private String careHomeName;
	private String careHomeEmail;
	private String pharmacyEmail;
	private String medicationName;
	private String residentName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yy")
	private Date cycleEndDate;
	
	public EmailRequest(String careHomeName, String careHomeEmail,
			String pharmacyEmail, String medicationName, String residentName) {
		this.usersEmail = careHomeEmail;
		this.usersName = careHomeName;
		this.careHomeEmail = careHomeEmail;
		this.careHomeName = careHomeName;
		this.pharmacyEmail = pharmacyEmail;
		this.medicationName = medicationName;
		this.residentName = residentName;
	}
	
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getCareHomeName() {
		return careHomeName;
	}
	public void setCareHomeName(String careHomeName) {
		this.careHomeName = careHomeName;
	}
	public String getPharmacyEmail() {
		return pharmacyEmail;
	}
	public void setPharmacyEmail(String pharmacyEmail) {
		this.pharmacyEmail = pharmacyEmail;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public Date getCycleEndDate() {
		return cycleEndDate;
	}
	public void setCycleEndDate(Date cycleEndDate) {
		this.cycleEndDate = cycleEndDate;
	}
	public String getCareHomeEmail() {
		return careHomeEmail;
	}
	public void setCareHomeEmail(String careHomeEmail) {
		this.careHomeEmail = careHomeEmail;
	}
	
}