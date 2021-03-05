package com.group3.backend.ui.model.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskRequest {
	
	private Long taskId;	
	private Long careWorkerId;
	private Long careHomeId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date dueTime;
	
	public Date getDueTime() {
		return dueTime;
	}
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
	private String text;
	private boolean isComplete;
	
	public Long getTaskId() {
		return taskId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public Long getCareWorkerId() {
		return careWorkerId;
	}
	public void setCareWorkerId(Long careWorkerId) {
		this.careWorkerId = careWorkerId;
	}
	public Long getCareHomeId() {
		return careHomeId;
	}
	public void setCareHomeId(Long careHomeId) {
		this.careHomeId = careHomeId;
	}
	
	
}
