package com.group3.backend.ui.model.request;

public class AutomaticEmailRequest {
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
