package com.group3.backend.datasource.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="medication_dose")
public class MedicationDoseEntity {
    @Id
    @GeneratedValue
    private long medDoseId;
    
    private Date timeToTake;
    private String dose;
    
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
}
