package com.group3.backend.ui.model.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MedicationDoseRequest {
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date time;
	private String repeats;
	private String dose;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getRepeats() {
		return repeats;
	}
	public void setRepeats(String repeats) {
		this.repeats = repeats;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
}
