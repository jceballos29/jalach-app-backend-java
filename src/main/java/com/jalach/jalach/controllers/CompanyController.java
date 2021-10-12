package com.jalach.jalach.controllers;

import com.jalach.jalach.models.Company;
import com.jalach.jalach.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @DeleteMapping(value = "/company/{rut}")
    public Company deleteCompany(@PathVariable Integer rut){
        return companyService.deleteCompany(rut);
    }

    @PutMapping(value = "/company/{rut}")
    public Company updateCompany(@PathVariable Integer rut, @RequestBody Company updatedCompany){
        return companyService.updateCompany(rut, updatedCompany);
    }

    @PostMapping(value = "company/{rut}/business_hours")
    public Company setBusinessHours (@PathVariable Integer rut, @RequestBody Company businessHours){

        return companyService.setBusinessHours(rut, businessHours);
    }

    @PostMapping(value = "/company/{rut}")
    public Company setNotFirstTime(@PathVariable Integer rut){
        return companyService.setNotFirstTime(rut);
    }
}
