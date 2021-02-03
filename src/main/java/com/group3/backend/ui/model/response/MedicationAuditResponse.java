package com.group3.backend.ui.model.response;

import java.util.Date;

public class MedicationAuditResponse {

	private long medCountId;
	private boolean isMorningCount; //if not morning count, will be the evening count
	private Date countDoneOnDate;
	private Date cyclePredictedToEndOn;
	private int count;

	public long medCountId(){
		return medCountId;
	}
	public void setMedCountId(long medCountId){
		this.medCountId = medCountId;
	}

	public boolean isMorningCount() {
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
