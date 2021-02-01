package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="alert")
public class AlertEntity implements Serializable {
	private static final long serialVersionUID = -5394839336979066672L;
	
	@Id
    @GeneratedValue
    private long alertId;
	
	private Date dateCreated;
	
	@OneToOne(fetch = FetchType.LAZY)
	private EmailEntity email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medForResId")
	private MedicationForResidentEntity medForResident;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return alertId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public EmailEntity getEmail() {
		return email;
	}

	public MedicationForResidentEntity getMedForResident() {
		return medForResident;
	}

	public void setId(long id) {
		this.alertId = id;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setEmail(EmailEntity email) {
		this.email = email;
	}

	public void setMedForResident(MedicationForResidentEntity medForResident) {
		this.medForResident = medForResident;
	}
}
