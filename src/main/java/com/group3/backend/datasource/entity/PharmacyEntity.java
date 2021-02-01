package com.group3.backend.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity(name="pharmacy")
public class PharmacyEntity implements Serializable {
	private static final long serialVersionUID = 2407906315820375745L;

	@Id
    @GeneratedValue
    private long pharmacyId;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacy")
    private List<MedicationForResidentEntity> medForResident;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "careHomeId")
    private CareHomeEntity careHome;
    

	@Column(nullable=false) //nullable flase indicates that the field MUST be included
    private String name;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String phoneNumb;
    private String address;

    public long getId() {
        return pharmacyId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public CareHomeEntity getCareHome() {
		return careHome;
	}

	public void setCareHome(CareHomeEntity careHome) {
		this.careHome = careHome;
	}
}
