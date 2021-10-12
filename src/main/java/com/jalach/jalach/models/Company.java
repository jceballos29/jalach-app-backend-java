package com.jalach.jalach.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
    

    @Id
    @Column(name="rut")
    private Integer rut;

    @Column(name = "business_name")
    private String business_name;

    @Column(name = "user")
    private String user;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "opening_time")
    private String opening_time;

    @Column(name = "closing_time")
    private String closing_time;

    @Column(name = "first_time")
    private boolean first_time = true;


    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public boolean isFirst_time() {
        return first_time;
    }

    public void setFirst_time(boolean first_time) {
        this.first_time = first_time;
    }

    
}


