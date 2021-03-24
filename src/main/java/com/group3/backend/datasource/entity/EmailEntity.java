package com.group3.backend.datasource.entity;

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.group3.backend.service.helper.EmailStatus;

//database will store all the details that were used to create the email. Then if we want to retrieve the actual email that was sent, we can just do the substitutions again.

@Entity(name="email")
public class EmailEntity implements Serializable {
	private static final long serialVersionUID = 3991032399210763160L;
	
	private Date datePharmacySaysReady;
	private Date dateRequested;
	private Date lastEmailSentDate;
	private Date requestLastUpdatedByPharmacy;
	private String pharmacyInquiryComment;
	private String status = EmailStatus.SENT_INITIAL_EMAIL.getMessage();
	
	@Id
	private String nonGuessableId;
	
	@OneToOne(fetch = FetchType.LAZY)
	private AlertEntity alertCreatedFrom;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pharmacyId")
	private PharmacyEntity pharmacySentTo;
	
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
	public Date getDatePharmacySaysReady() {
		return datePharmacySaysReady;
	}
	public void setDatePharmacySaysReady(Date datePharmacySaysReady) {
		this.datePharmacySaysReady = datePharmacySaysReady;
	}
	public Date getDateRequested() {
		return dateRequested;
	}
	public void setDateRequested(Date dateRequested) {
		this.dateRequested = dateRequested;
	}
	public Date getLastEmailSentDate() {
		return lastEmailSentDate;
	}
	public void setLastEmailSentDate(Date lastEmailSentDate) {
		this.lastEmailSentDate = lastEmailSentDate;
	}
	public Date getRequestLastUpdatedByPharmacy() {
		return requestLastUpdatedByPharmacy;
	}
	public void setRequestLastUpdatedByPharmacy(Date requestLastUpdatedByPharmacy) {
		this.requestLastUpdatedByPharmacy = requestLastUpdatedByPharmacy;
	}
	
	public String getPharmacyInquiryComment() {
		return pharmacyInquiryComment;
	}
	public void setPharmacyInquiryComment(String pharmacyInquiryComment) {
		this.pharmacyInquiryComment = pharmacyInquiryComment;
	}
	
	public String getCareHomeName() {
		return this.alertCreatedFrom.getMedForResident().getResident().getCareHome().getName();
	}
	
	public PharmacyEntity getPharmacy() {
		return this.pharmacySentTo;
	}
	
	public AlertEntity getAlertCreatedFrom() {
		return this.alertCreatedFrom;
	}
	
	public PharmacyEntity getPharmacySentTo() {
		return pharmacySentTo;
	}
	public void setPharmacySentTo(PharmacyEntity pharmacySentTo) {
		this.pharmacySentTo = pharmacySentTo;
	}
	public void setAlertCreatedFrom(AlertEntity alertCreatedFrom) {
		this.alertCreatedFrom = alertCreatedFrom;
	}	
    
}