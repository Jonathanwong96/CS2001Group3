package com.group3.backend.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="resident")
public class ResidentEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long residentId;
	
    @Column(nullable=false)
	private Long careHomeId;
    @Column(nullable=false)
	private String firstName;
    @Column(nullable=false)
	private String surName;
	private int age;
	private String guardianName;
	private String bio;
	
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
	public Long getCareHomeId() {
		return careHomeId;
	}
	public void setCareHomeId(Long careHomeId) {
		this.careHomeId = careHomeId;
	}
}
