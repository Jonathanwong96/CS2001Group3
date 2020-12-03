package com.group3.backend.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="pharmacy")
public class PharmacyEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false) //nullable flase indicates that the field MUST be included
    private String name;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String phoneNumb;
    @Column(nullable=false)
    private Long careHomeId;
    private boolean isDefault;
    private String address;

    public long getId() {
        return id;
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

    public Long getCareHomeId() {
        return careHomeId;
    }

    public void setCareHomeId(Long careHomeId) {
        this.careHomeId = careHomeId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
