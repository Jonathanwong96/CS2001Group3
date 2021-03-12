package org.springframework.web.servlet.config.annotation;

@Id
@GeneratedValue
private int Id; //this Id should be the resident's identification so residentId

@Column(nullable=false)
private char Name; //resident name

@Column(nullable=false)
private char Description; 



public medication() {

}

public medication(String Name, Integer ID, String desription) {
	this.ID = residentName;
	this.name = medsIntialSatrtDate;
	this.description=  medicationDosage; //evening + day count
	
}
//Staff responsible for the updates and changes
public long getId() {
	return ID;
}
public void setId(int Id) {
	this.ID = Id;
}


public Medication(String residentName, Integer medsInitialStartDate, Integer medicationDosage,Integer initialMedicationCount, Integer projectEndDate) {
	this.residentName = residentName;
	this.id = medsIntialSatrtDate;
	this.description =  medicationDosage; //evening + day count
}


//Staff responsible for the updates and changes
public long getStaffId() {
	return staffID;
}
public void setStaffId(int staffId) {
	this.staffID = staffId;
}

//Name
public String getResidentname() {
	return residentName;
}
public void setresidentName(String residentName) {
	this.residentName = residentName;
}

//Morning Count
public String getDescription() {
	return description;
}
public void description(String description) {
	this.description = description;
}

}
