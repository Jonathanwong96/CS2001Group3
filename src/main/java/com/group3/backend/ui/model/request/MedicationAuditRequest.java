package com.group3.backend.ui.model.request;

public class MedicationAuditRequest {

	private Long id;
	private String name;
	private int dayCount;
	private int eveningCount;
	private int initialMedicationCount;
	private Long staffId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public int getEveningCount() {
		return eveningCount;
	}
	public void setEveningCount(int eveningCount) {
		this.eveningCount = eveningCount;
	}

	public int getInitialMedicationCount() {
		return initialMedicationCount;
	}
	public void setInitialMedicationCount(int initialMedicationCount) {
		this.initialMedicationCount = initialMedicationCount;
	}

	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}



}
