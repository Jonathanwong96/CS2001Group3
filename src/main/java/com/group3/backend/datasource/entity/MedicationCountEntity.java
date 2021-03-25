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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="medication_count")
public class MedicationCountEntity implements Serializable, Comparable<MedicationCountEntity> {
	private static final long serialVersionUID = 3991032399210763160L;

	@Id
    @GeneratedValue
    private Long medCountId;
	private boolean isMorningCount; //if not morning count, will be the evening count

	@Temporal(TemporalType.DATE)
	private Date countDoneOnDate;
	
	@Temporal(TemporalType.DATE)
	private Date cyclePredictedToEndOn;
	private int count;
	private String careWorkerName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medForResId")
	private MedicationForResidentEntity medicationForResident;
	
	public MedicationForResidentEntity getMedicationForResident() {
		return medicationForResident;
	}
	public void setMedicationForResident(MedicationForResidentEntity medicationForResident) {
		this.medicationForResident = medicationForResident;
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
	
	public Long getMedCountId(){
		return medCountId;
	}
	public void setMedCountId(Long medCountId){
		this.medCountId = medCountId;
	}
	
	@Override
	public int compareTo(MedicationCountEntity that) {
		int compare = that.getCountDoneOnDate().compareTo(this.getCountDoneOnDate());
		if (compare == 0) {
			return this.isMorningCount ? 1 : -1;
		} else {
			return compare;
		}
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
