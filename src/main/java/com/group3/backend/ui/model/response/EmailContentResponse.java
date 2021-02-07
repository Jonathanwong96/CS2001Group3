package com.group3.backend.ui.model.response;

public class EmailContentResponse {
	String nonGuessableId;
	String emailHtml;	
	
	public String getNonGuessableId() {
		return nonGuessableId;
	}
	public void setNonGuessableId(String nonGuessableId) {
		this.nonGuessableId = nonGuessableId;
	}
	public String getEmailHtml() {
		return emailHtml;
	}
	public void setEmailHtml(String emailHtml) {
		this.emailHtml = emailHtml;
	}	
}
