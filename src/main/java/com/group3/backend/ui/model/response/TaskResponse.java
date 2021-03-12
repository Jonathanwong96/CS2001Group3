package com.group3.backend.ui.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskResponse {
	
	private Long taskId;	
	private Long careWorkerId;
	private Long careHomeId;
	private String careWorkerName;
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
	private String operationMessage;
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
	public String getOperationMessage() {
		return operationMessage;
	}
	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}
	public Long getCareHomeId() {
		return careHomeId;
	}
	public void setCareHomeId(Long careHomeId) {
		this.careHomeId = careHomeId;
	}
	public Long getCareWorkerId() {
		return careWorkerId;
	}
	public void setCareWorkerId(Long careWorkerId) {
		this.careWorkerId = careWorkerId;
	}
	public String getCareWorkerName() {
		return careWorkerName;
	}
	public void setCareWorkerName(String careWorkerName) {
		this.careWorkerName = careWorkerName;
	}
}
