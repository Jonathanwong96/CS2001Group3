package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//database will store all the details that were used to create the email. Then if we want to retrieve the actual email that was sent, we can just do the substitutions again.

@Entity(name="email")
public class EmailEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 712443853674416421L;

	@Id
    @GeneratedValue
    private long id;
 
    private String medicationName;
    @Column(nullable=false)
    private String nonGuessableId;
    private String status = "unresponded";
    private String replyToAddr;
    private String careHomeName;
    @Column(nullable=false)
    private String pharmacyEmail;
    private String pharmacyName;
    private String residentName;
    private String careWorkerName;
    private Date dateSent;
    private Date dateUpdatedByPharmacy;
    private String pharmacyComment;
    private Date dateMedicationToBeReady;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getNonGuessableId() {
		return nonGuessableId;
	}
	public void setNonGuessableId(String nonGuessableId) {
		this.nonGuessableId = nonGuessableId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getReplyToAddr() {
		return replyToAddr;
	}
	public void setReplyToAddr(String replyToAddr) {
		this.replyToAddr = replyToAddr;
	}
	public String getCareHomeName() {
		return careHomeName;
	}
	public void setCareHomeName(String careHomeName) {
		this.careHomeName = careHomeName;
	}
	public String getPharmacyEmail() {
		return pharmacyEmail;
	}
	public void setPharmacyEmail(String pharmacyEmail) {
		this.pharmacyEmail = pharmacyEmail;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getCareWorkerName() {
		return careWorkerName;
	}
	public void setCareWorkerName(String usersName) {
		this.careWorkerName = usersName;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	public Date getDateUpdatedByPharmacy() {
		return dateUpdatedByPharmacy;
	}
	public void setDateUpdatedByPharmacy(Date dateUpdatedByPharmacy) {
		this.dateUpdatedByPharmacy = dateUpdatedByPharmacy;
	}
	public String getPharmacyComment() {
		return pharmacyComment;
	}
	public void setPharmacyComment(String pharmacyComment) {
		this.pharmacyComment = pharmacyComment;
	}
	public Date getDateMedicationToBeReady() {
		return dateMedicationToBeReady;
	}
	public void setDateMedicationToBeReady(Date dateMedicationToBeReady) {
		this.dateMedicationToBeReady = dateMedicationToBeReady;
	}
	
    
}