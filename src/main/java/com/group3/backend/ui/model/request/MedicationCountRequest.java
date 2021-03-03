package com.group3.backend.ui.model.request;

import java.util.Date;

public class MedicationCountRequest {

	private boolean isMorningCount; //if not morning count, will be the evening count
	private int count;
	private long medForResId;
	private String careWorkerName;

	public boolean getIsMorningCount() {
		return isMorningCount;
	}
	public void setMorningCount(boolean isMorningCount) {
		this.isMorningCount = isMorningCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getMedForResId() {
		return medForResId;
	}
	public void setMedForResId(long medForResId) {
		this.medForResId = medForResId;
	}
	/**
	 * @return the careWorkerName
	 */
	public String getCareWorkerName() {
		return careWorkerName;
	}
	/**
	 * @param careWorkerName the careWorkerName to set
	 */
	public void setCareWorkerName(String careWorkerName) {
		this.careWorkerName = careWorkerName;
	}

}
