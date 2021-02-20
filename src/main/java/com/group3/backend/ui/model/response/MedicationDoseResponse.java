package com.group3.backend.ui.model.response;

import java.util.Date;

public class MedicationDoseResponse {
	private String medicationName;
	private String dose;
	private Date time;
	private long residentId;
	private String residentName;
	private String repeats;
	
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public long getResidentId() {
		return residentId;
	}
	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}
	public String getRepeats() {
		return repeats;
	}
	public void setRepeats(String repeats) {
		this.repeats = repeats;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
}
