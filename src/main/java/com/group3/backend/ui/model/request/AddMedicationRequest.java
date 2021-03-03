package com.group3.backend.ui.model.request;

import java.util.ArrayList;

public class AddMedicationRequest {
	private long medId = -1;
	private long resId = -1;
	private long pharmacyId = -1;
	private String medName;
	private String medDesc;
	private ArrayList<MedicationDoseRequest> medDoses;
	
	public long getMedId() {
		return medId;
	}
	public void setMedId(long medId) {
		this.medId = medId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedDesc() {
		return medDesc;
	}
	public void setMedDesc(String medDesc) {
		this.medDesc = medDesc;
	}
	public ArrayList<MedicationDoseRequest> getMedDoses() {
		return medDoses;
	}
	public void setMedDoses(ArrayList<MedicationDoseRequest> medDoses) {
		this.medDoses = medDoses;
	}
	public long getResId() {
		return resId;
	}
	public void setResId(long resId) {
		this.resId = resId;
	}
	public long getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(long pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
}
