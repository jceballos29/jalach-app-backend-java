package com.jalach.jalach.services;

import com.jalach.jalach.models.Company;

public interface AuthService {
    boolean validateCompany(Company company);
    boolean validateCompanyByRut(Integer rut);
    Company registerCompany(Company company);
    Company loginCompany(Company company);
}
