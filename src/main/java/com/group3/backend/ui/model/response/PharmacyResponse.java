package com.group3.backend.ui.model.response;

public class PharmacyResponse {
    private String email;
    private String address;
    private String phoneNumb;
    private Long careHomeId;
    private boolean isDefault = false;
    private String name;

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
}
