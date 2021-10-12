package com.jalach.jalach.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jalach.jalach.models.Company;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CompanyServiceImp implements CompanyService{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Company deleteCompany(Integer rut) {
        Company company = entityManager.find(Company.class, rut);
        if(company != null){
            entityManager.remove(company);
            return company;
        }
        return null;
    }

    @Override
    public Company updateCompany(Integer rut, Company updatedCompany) {
        Company company = entityManager.find(Company.class, rut);
        if(company != null){
            return entityManager.merge(company);
        }
        return null;
    }

    @Override
    public Company setBusinessHours(Integer rut, Company businessHours) {
        Company company = entityManager.find(Company.class, rut);
        company.setOpening_time(businessHours.getOpening_time());
        company.setClosing_time(businessHours.getClosing_time());
        return entityManager.merge(company);
    }

    @Override
    public Company setNotFirstTime(Integer rut) {
        Company company = entityManager.find(Company.class, rut);
        company.setFirst_time(false);
        return entityManager.merge(company);
    }
    
}
