package com.group3.backend.datasource.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="task")
public class TaskEntity {

	@Id
	@GeneratedValue
	private Long taskId;	
	
	private String text;
    
    private Date dueTime;
	private boolean isComplete = false;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carehomeId")
	private CareHomeEntity careHome;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="careWorkerId")
    private CareWorkerEntity careWorker;
	
	public CareWorkerEntity getCareWorker() {
		return careWorker;
	}
	
	public Long getCareWorkerId() {
		return this.careWorker.getCareWorkerId();
	}

	public void setCareWorker(CareWorkerEntity careWorker) {
		this.careWorker = careWorker;
	}

	public CareHomeEntity getCareHome() {
		return careHome;
	}
	
	public Long getCareHomeId() {
		return this.careHome.getCareHomeId();
	}

	public void setCareHome(CareHomeEntity careHome) {
		this.careHome = careHome;
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
	
	public Long getTaskId() {
		return taskId;
	}

	public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
}
