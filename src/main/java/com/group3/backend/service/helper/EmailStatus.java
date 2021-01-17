package com.group3.backend.service.helper;

public enum EmailStatus {
	PROCESSING("Processing"), SENT_INITIAL_EMAIL("Sent initial email"),
	INQUIRY("Inquiry"), ASKED_IF_READY("Asked if medication is ready"), READY("Ready to collect!");
	
	private String message;
	
	EmailStatus(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return this.message;
	}

}
