package com.group3.backend.ui.model.response;

public class MedicationForResidentResponse {
	private long medicationId;
	private long residentId;
	private long pharmacyId;
	
	public long getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(long medicationId) {
		this.medicationId = medicationId;
	}
	public long getResidentId() {
		return residentId;
	}
	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}
	public long getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	
	
}
