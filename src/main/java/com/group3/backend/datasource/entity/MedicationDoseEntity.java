package com.group3.backend.datasource.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="medication_dose")
public class MedicationDoseEntity implements Comparable<MedicationDoseEntity> {
    @Id
    @GeneratedValue
    private long medDoseId;
    
    private Date timeToTake;
    private String dose;
    private String repetition;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medForResId")
    private MedicationForResidentEntity medicationforResident;

	public Date getTimeToTake() {
		return timeToTake;
	}

	public void setTimeToTake(Date timeToTake) {
		this.timeToTake = timeToTake;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
	public String getRepetition() {
		return repetition;
	}

	public void setRepetition(String repetition) {
		this.repetition = repetition;
	}

	public MedicationForResidentEntity getMedicationforResident() {
		return medicationforResident;
	}

	public void setMedicationforResident(MedicationForResidentEntity medicationforResident) {
		this.medicationforResident = medicationforResident;
	}
	
	@Override
	public int compareTo(MedicationDoseEntity that) {
		return that.getTimeToTake().compareTo(this.getTimeToTake());
	}
}
