package com.group3.backend.datasource.entity;
//Model

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MedicationAuditEntity implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id; //this Id should be the resident's identification so residentId

	@Column(nullable=false)
    private String name; //resident name

    @Column(nullable=false)
    private Integer dayCount;

    @Column(nullable=false)
    private Integer eveningCount;

    @Column(nullable=false)
    private Integer initialMedicationCount;

    @Column(nullable = false)
    private long staffId;


    public MedicationAuditEntity() {

    }

    public MedicationAuditEntity(String name, Integer dayCount, Integer eveningCount, Integer initialMedicationCount) {
    	this.name = name;
    	this.dayCount = dayCount;
    	this.eveningCount = eveningCount;
    	this.initialMedicationCount = initialMedicationCount;
    }


    //Id
    public long getId() {
    	return id;
    }

    //Staff responsible for the updates and changes
    public long getStaffId() {
    	return staffId;
    }
    public void setStaffId(int staffId) {
    	this.staffId = staffId;
    }

    //Name
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }

    //Morning Count
    public int getDayCount() {
    	return dayCount;
    }
    public void setDayCount(int dayCount) {
    	this.dayCount = dayCount;
    }

    //Evening Count
    public int getEveningCount() {
    	return eveningCount;
    }
    public void setEveningCount(int eveningCount) {
    	this.eveningCount = eveningCount;
    }


    //Initial Medication Count
    public int getInitialMedicationCount() {
    	return initialMedicationCount;
    }
    public void setInitialMedicationCount(int initialMedicationCount) {
    	this.initialMedicationCount = initialMedicationCount;
    }


}
