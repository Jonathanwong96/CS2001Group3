package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="medication")
public class MedicationEntity implements Serializable {
	private static final long serialVersionUID = -9195120155097865548L;

	@Id
    @GeneratedValue
    private long medicationId;

    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="medication")
    private List<MedicationForResidentEntity> allResidentsForMedication;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
