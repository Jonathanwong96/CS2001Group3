package com.group3.backend.datasource.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name ="medication")
public class MedicationEntity implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
  private long id; //this Id should be used to identify medication in the system
  
  @Column(nullable=false)
  private String medicationName; 

  @Column (nullable=false)
  private int prescriptionCount;

  @Column(nullable=false)
  private String description;

  @Column(nullable=false)
  private String medicationClass;

  @Column(nullable=false)
  private String dosage;

  @Column(nullable=false)
  private String pharmacyName;


  public MedicationEntity() {

  }

  public MedicationEntity(String medicationName, int prescriptionCount, String description, String medicationClass, String dosage, String pharmacyName) {
    this.medicationName = medicationName;
    this.prescriptionCount = prescriptionCount;
    this.description = description;
    this.medicationClass = medicationClass;
    this.dosage = dosage;
    this.pharmacyName = pharmacyName;
  }

  //Id
  public long getId() {
    return id;
  }

  //Medication Name
  public String getMedicationName() {
    return medicationName;
  }
  public void setMedicationName(String medicationName) {
    this.medicationName = medicationName;
  }

  //prescription count when arrives from pharmacy
  public int getPrecriptionCount() {
    return prescriptionCount;
  }
  public void setPrescriptionCount(int prescriptionCount) {
    this.prescriptionCount = prescriptionCount;
  }

  //Medication Description
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

//Medication class (medication are also classified)
  public String getMedicationClass() {
    return medicationClass;
  }
  public void setMedicationClass(String medicationClass) {
    this.medicationClass = medicationClass;
  }

//dosage per tablet
  public String getDosage() {
    return dosage;
  }
  public void setDosage(String dosage) {
    this.dosage = dosage;
  }

  //Pharmacy where drugs came from
  public String getPharmacyName() {
    return pharmacyName;
  }
  public void setPharmacyName(String pharmacyName) {
    this.pharmacyName = pharmacyName;
  }

}
