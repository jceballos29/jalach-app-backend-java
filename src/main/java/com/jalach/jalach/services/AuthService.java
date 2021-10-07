package com.jalach.jalach.services;

import com.jalach.jalach.models.Company;

public interface AuthService {
    boolean validateCompany(Company company);
    Company registerCompany(Company company);
}
