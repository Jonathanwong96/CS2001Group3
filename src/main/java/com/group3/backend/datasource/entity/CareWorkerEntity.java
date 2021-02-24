package com.group3.backend.datasource.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="careworker")
public class CareWorkerEntity {

	@Id
	@GeneratedValue
	private Long careWorkerId;
	
	@Column(nullable=false)
	private String firstName;
    @Column(nullable=false)
	private String surName;
	private boolean archived = false;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carehomeId")
	private CareHomeEntity careHome;
	
	public boolean isArchived() {
		return archived;
	}
	public void setArchived(boolean archived) {
		this.archived = archived;
	}	

    public Long getCareWorkerId() {
		return careWorkerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String sureName) {
		this.surName = sureName;
	}
	public String getFullName() {
		return this.firstName + " " + this.surName;
	}
	
	public CareHomeEntity getCareHome() {
		return careHome;
	}
	public void setCareHome(CareHomeEntity careHome) {
		this.careHome = careHome;
	}
}
