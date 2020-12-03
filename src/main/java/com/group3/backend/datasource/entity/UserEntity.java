package com.group3.backend.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private long careHomeId;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String encryptedPassword;
    @Column(nullable=false)
    private String role = "standard";
    @Column(nullable=false, unique = true)
    private String email;

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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
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
