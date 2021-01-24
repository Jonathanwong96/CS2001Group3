package com.group3.backend.service.helper;

public enum EmailStatus { 
	SENT_INITIAL_EMAIL("Sent initial email"),
	PROCESSING("Processing"),
	INQUIRY("Inquiry"), 
	ASKED_IF_READY("Asked if medication is ready"), 
	READY("Ready to collect!"),
	COMPLETED("Completed");
	
	private String message;
	
	EmailStatus(String msg) {
		this.message = msg;
	}
	
	public String getMessage() {
		return this.message;
	}

}
