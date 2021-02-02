package com.group3.backend.ui.model.response;

public enum ErrorMessages {
	COULD_NOT_FIND("Could not find an item that matches the request."), 
	BAD_DATE_FORMAT("Could not parse this date"),
	UNABLE_TO_SEND_EMAIL("Could not send email"),
	NOT_RIGHT_STEP("Email status not at right step to do this action"),
	SENDING_TOO_SOON("Need to wait at least 1 day before this email can be resent."),
	ALERT_HAS_EMAIL("This alert already has an email associated with it.");
	
	private String errorMessage;
	
	ErrorMessages(String err) {
		this.errorMessage = err;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
