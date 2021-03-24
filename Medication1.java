package org.springframework.web.servlet.config.annotation;
package org.springframework.web.servlet.config.annotation;

@Id
@GeneratedValue


@Column(nullable=false)
private int medicationResidentId; 
@Column(nullable=false)
private Date timeToTake; //resident name
@Column(nullable=false)
private int dose; 


public Medication1(Integer medicationResidentId, Integer dose, Date timeToTake) {
	this.medicationResidentId = medicationResidentId;
	this.timeToTake= timeToTake;
	this.dose=  medicationDosage; //evening + day count
	
}
//Staff responsible for the updates and changes
public long getId() {
	return ID;
}
public void setId(int Id) {
	this.ID = Id;
}


public MedicationDose(String residentNam, Date timeToTake, Integer dose) {
	this.residentName = residentName;
	this.timeToTake= timeToTake;
	this.dose = dose; //evening + day count
}


//Staff responsible for the updates and changes
public int getmedicationResidentId() {
	return medicationResidentId;
}
public void setmedicationResidentId(int medicationResidentId) {
	this.medicationResidentId = medicationResidentId;
}

//Name
public Date getTimeToTake() {
	return timeToTake;
}
public void timeToTake(Date timeToTake) {
	this.timeToTake= timeToTake;
}

//Morning Count
public int getDose() {
	return dose;
}
public void dose(int dose) {
	this.dose= dose;
}

}

