package com.group3.backend.ui.model.response;

public class MedicationResponse {
	
	private long medicationId;
    private String name;
    private String description;
    
	public long getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
