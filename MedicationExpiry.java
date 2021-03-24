    package com.group3.backend.ui.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
	import java.io.Serializable;
   
    
    import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;

	@Entity(name ="medication")
	public class MedicationExpiry implements Serializable  {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		private int staffID; //this Id should be the resident's identification so residentId

		@Column(nullable=false)
	    private String residentName; //resident name

	    @Column(nullable=false)
	    private int medsIntialSatrtDate; 

	    @Column(nullable=false)
	    private Integer initialMedicationCount; 
	    @Column(nullable=false)
	    private Integer medicationDosage; //includes day + evening total


	    @Column(nullable = false)
	    private int projectEndDate; //(initial count/ dosage) project days on calendar to get expiry date

		

	    public MedicationExpiry  () {

	    }

	    public MedicationExpiry(String residentName, Integer medsInitialStartDate, Integer medicationDosage,Integer initialMedicationCount, Integer projectEndDate) {
	    	this.residentName = residentName;
	    	this.medsIntialSatrtDate = medsIntialSatrtDate;
	    	this.medicationDosage =  medicationDosage; //evening + day count
	    	this.initialMedicationCount = initialMedicationCount;
	    	this.projectEndDate = projectEndDate;  //initialMedicationCount/medicationDosage
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
	    public String getResidentname() {
	    	return residentName;
	    }
	    public void setresidentName(String residentName) {
	    	this.residentName = residentName;
	    }

	    //Morning Count
	    public int getMedsIntialSatrtDate() {
	    	return medsIntialSatrtDate;
	    }
	    public void  medsIntialSatrtDate(int  medsIntialSatrtDate) {
	    	this. medsIntialSatrtDate = medsIntialSatrtDate;
	    }

	    //Medication DOsage
	    public int getMedicationDosage() {
	    	return medicationDosage;
	    }
	    public void medicationDosage(int medicationDosage) {
	    	this.medicationDosage = medicationDosage;
	    }

	  //Medication DOsage
	    public int getprojectEndDate() {
	    	return projectEndDate;
	    }
	    public void getprojectEndDate(int projectEndDate) {
	    	this.projectEndDate = projectEndDate;
	    }

	    //Initial Medication Count
	    public int getInitialMedicationCount() {
	    	return initialMedicationCount;
	    }
	    public void setInitialMedicationCount(int initialMedicationCount) {
	    	this.initialMedicationCount = initialMedicationCount;
	    }


	}
	
	
	
	
