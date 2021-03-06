package com.group3.backend.ui.model.response;

public class ResidentResponse {
	
	private Long residentId;
	private Long careHomeId;
	private String firstName;
	private String surName;
	private int age;
	private String guardianName;
	private String bio;
	private String operationMessage;
	private boolean archived;


	public boolean isArchived() {
		return archived;
	}
	public void setArchived(boolean archived) {
		this.archived = archived;
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
	public Long getCareHomeId() {
		return careHomeId;
	}
	public void setCareHomeId(Long careHomeId) {
		this.careHomeId = careHomeId;
	}
	public Long getResidentId() {
		return residentId;
	}
	public void setResidentId(Long residentId) {
		this.residentId = residentId;
	}
	public String getOperationMessage() {
		return operationMessage;
	}
	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}

	public String getFullName() {
		return this.firstName + " " + this.surName;
	}
}
