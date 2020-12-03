package com.group3.backend.ui.model.response;

public class UserResponse {
    private long careHomeId;
    private String name;
    private String email;
    private String role;

    public long getCareHomeId() {
        return careHomeId;
    }

    public void setCareHomeId(long careHomeId) {
        this.careHomeId = careHomeId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
