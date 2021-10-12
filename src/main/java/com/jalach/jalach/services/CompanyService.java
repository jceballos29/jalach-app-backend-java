package com.jalach.jalach.services;

import com.jalach.jalach.models.Company;

public interface CompanyService {
 
    Company deleteCompany(Integer rut);
    Company updateCompany(Integer rut, Company updatedCompany);
    Company setBusinessHours (Integer rut, Company businessHours);
    Company setNotFirstTime(Integer rut);
}
