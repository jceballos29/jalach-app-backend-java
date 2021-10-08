package com.jalach.jalach.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "business_rut")
    private Integer business_rut;

    @Column(name = "role")
    private String role;

    @Column(name = "color")
    private String color;

    @Column(name = "hourly")
    private Float hourly;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusiness_rut() {
        return business_rut;
    }

    public void setBusiness_rut(Integer business_rut) {
        this.business_rut = business_rut;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getHourly() {
        return hourly;
    }

    public void setHourly(Float hourly) {
        this.hourly = hourly;
    }

}
