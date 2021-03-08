package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="carehome")
public class CareHomeEntity implements Serializable {
	private static final long serialVersionUID = -3562870780099228900L;

	@Id
    @GeneratedValue
    private long careHomeId;

	private String name;
    private String email;
    private boolean usesAutoEmail = false;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="careHome")
    private List<ResidentEntity> residents;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="careHome")
    private List<CareWorkerEntity> careWorkers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="careHome")
    private List<PharmacyEntity> pharmacies;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="careHome")
    private List<TaskEntity> tasks;
    
	public List<TaskEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

	public List<ResidentEntity> getResidents() {
		return residents;
	}

	public void setResidents(List<ResidentEntity> residents) {
		this.residents = residents;
	}

	public List<CareWorkerEntity> getCareWorkers() {
		return careWorkers;
	}

	public void setCareWorkers(List<CareWorkerEntity> careWorkers) {
		this.careWorkers = careWorkers;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUsesAutoEmail() {
		return usesAutoEmail;
	}

	public void setUsesAutoEmail(boolean usesAutoEmail) {
		this.usesAutoEmail = usesAutoEmail;
	}

	public List<PharmacyEntity> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(List<PharmacyEntity> pharmacies) {
		this.pharmacies = pharmacies;
	}
	
    public long getCareHomeId() {
		return careHomeId;
	}

	public void setCareHomeId(long careHomeId) {
		this.careHomeId = careHomeId;
	}
}
