package com.group3.backend.ui.security;

public class JwtData {
    private final String careHomeId;
    private final String email;

    public JwtData(String careHomeId, String email) {
        this.careHomeId = careHomeId;
        this.email = email;
    }

    public String getCareHomeId() {
        return careHomeId;
    }

    public String getEmail() {
        return email;
    }
}
