package com.jalach.jalach.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jalach.jalach.models.Company;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthServiceImp implements AuthService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean validateCompany(Company company) {
        String query = "FROM Company WHERE email = :email AND user = :user";
        List<Company> matchCompany = entityManager.createQuery(query, Company.class)
                .setParameter("email", company.getEmail())
                .setParameter("user", company.getUser())
                .getResultList();
        
        return matchCompany.isEmpty();
    }

    @Override
    public Company registerCompany(Company company) {
        return entityManager.merge(company);
    }
    
}
