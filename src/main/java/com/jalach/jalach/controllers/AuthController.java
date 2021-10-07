package com.jalach.jalach.controllers;

import com.jalach.jalach.models.Company;
import com.jalach.jalach.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping(value = "/api/v1")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/register")
    public Company register(@RequestBody Company company){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if (authService.validateCompany(company)){ 
            char [] companyPassword = company.getPassword().toCharArray();
            String passwordHashed = argon2.hash(1, 1024, 1, companyPassword);
            company.setPassword(passwordHashed);

            return authService.registerCompany(company);
        }

        return null;
    }
    
}
