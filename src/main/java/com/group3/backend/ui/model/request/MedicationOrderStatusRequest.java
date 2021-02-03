package com.group3.backend.ui.model.request;

public class MedicationOrderStatusRequest {
	private String readyDate;
	private String requestId;
	private String comment;

	public String getReadyDate() {
		return readyDate;
	}

	public void setReadyDate(String readyDate) {
		this.readyDate = readyDate;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
