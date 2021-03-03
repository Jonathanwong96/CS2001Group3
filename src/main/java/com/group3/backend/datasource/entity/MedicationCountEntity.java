package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

@Entity(name="medication_count")
public class MedicationCountEntity implements Serializable, Comparable<MedicationCountEntity> {
	private static final long serialVersionUID = 3991032399210763160L;

	@Id
    @GeneratedValue
    private Long medCountId;
	private boolean isMorningCount; //if not morning count, will be the evening count
	private Date countDoneOnDate;
	private Date cyclePredictedToEndOn;
	private int count;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medForResId")
	private MedicationForResidentEntity medicationForResident;
	
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
	
	public MedicationForResidentEntity getMedicationForResidentEntity() {
		return this.medicationForResident;
	}
	public Long getMedCountId(){
		return medCountId;
	}
	public void setMedCountId(Long medCountId){
		this.medCountId = medCountId;
	}
	
	@Override
	public int compareTo(MedicationCountEntity that) {
		return that.getCountDoneOnDate().compareTo(this.getCountDoneOnDate());
	}
	
}
