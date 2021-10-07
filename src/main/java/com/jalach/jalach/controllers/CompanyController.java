package com.jalach.jalach.controllers;

import com.jalach.jalach.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping(value = "/api/v1")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @DeleteMapping(value = "company/{rut}")
    public String deleteCompany(@PathVariable Integer rut){
        try {
            companyService.deleteById(rut);
            return "Company Deleted Successfully";
        } catch (Exception e) {
            return "Company Deleted Unsuccessfully";
        }
    }

}
