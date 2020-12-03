package com.group3.backend.ui.model.request;

public class UserRequest {
    private long careHomeId;
    private String name;
    private String password;
    private String email;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCareHomeId() {
        return careHomeId;
    }

    public void setCareHomeId(long careHomeId) {
        this.careHomeId = careHomeId;
    }
}
