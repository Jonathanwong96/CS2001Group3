package com.group3.backend.datasource.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="auto_email")
public class AutomaticEmailEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

	private static final long serialVersionUID = 5720385193931392136L;

	private long careHomeId;
	private boolean usesAutomaticEmails;
	
	public long getCareHomeId() {
		return careHomeId;
	}
	public void setCareHomeId(long careHomeId) {
		this.careHomeId = careHomeId;
	}
	public boolean isUsesAutomaticEmails() {
		return usesAutomaticEmails;
	}
	public void setUsesAutomaticEmails(boolean usesAutomaticEmails) {
		this.usesAutomaticEmails = usesAutomaticEmails;
	}
}
