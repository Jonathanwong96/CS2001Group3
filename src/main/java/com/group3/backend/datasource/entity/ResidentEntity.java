package com.group3.backend.datasource.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="resident")
public class ResidentEntity {

	@Id
	@GeneratedValue
	private Long residentId;	
	
    @Column(nullable=false)
	private String firstName;
    @Column(nullable=false)
	private String surName;
	private int age;
	private String guardianName;
	private String bio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carehomeId")
	private CareHomeEntity careHome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resident")
	private List<MedicationForResidentEntity> allMedicationsForResident;
	
	
	
	public Long getResidentId() {
		return residentId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public void setResidentId(Long residentId) {
		this.residentId = residentId;
	}

	public CareHomeEntity getCareHome() {
		return careHome;
	}
	
	public List<MedicationForResidentEntity> getAllMedicationsForResident() {
		return allMedicationsForResident;
	}
	public void setAllMedicationsForResident(List<MedicationForResidentEntity> allMedicationsForResident) {
		this.allMedicationsForResident = allMedicationsForResident;
	}
	public void setCareHome(CareHomeEntity careHome) {
		this.careHome = careHome;
	}
}
