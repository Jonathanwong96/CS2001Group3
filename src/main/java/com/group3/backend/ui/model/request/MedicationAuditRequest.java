package com.group3.backend.ui.model.request;

import java.util.Date;

public class MedicationAuditRequest {

	private Long medCountId;
	private boolean isMorningCount; //if not morning count, will be the evening count
	private Date countDoneOnDate;
	private Date cyclePredictedToEndOn;
	private int count;

	public Long getMedCountId(){
		return medCountId;
	}
	public void setMedCountId(Long medCountId){
		this.medCountId = medCountId;
	}

	public boolean getIsMorningCount() {
		return isMorningCount;
	}
	public void setMorningCount(boolean isMorningCount) {
		this.isMorningCount = isMorningCount;
	}
	public Date getCountDoneOnDate() {
		return countDoneOnDate;
	}
	public void setCountDoneOnDate(Date countDoneOnDate) {
		this.countDoneOnDate = countDoneOnDate;
	}
	public Date getCyclePredictedToEndOn() {
		return cyclePredictedToEndOn;
	}
	public void setCyclePredictedToEndOn(Date cyclePredictedToEndOn) {
		this.cyclePredictedToEndOn = cyclePredictedToEndOn;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}



}
