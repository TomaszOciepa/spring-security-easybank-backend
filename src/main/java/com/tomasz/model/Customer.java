package com.tomasz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String pwd;
    private String role;

    private LocalDateTime dateRegistration;

    public Customer() {
    }

    public Customer(String name, String email, String pwd, String role, LocalDateTime dateRegistration) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.role = role;
        this.dateRegistration = dateRegistration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

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

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
