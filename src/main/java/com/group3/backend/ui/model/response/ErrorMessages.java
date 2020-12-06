package com.group3.backend.ui.model.response;

public enum ErrorMessages {
	COULD_NOT_FIND("Could not find an item that matches the request.");
	
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
