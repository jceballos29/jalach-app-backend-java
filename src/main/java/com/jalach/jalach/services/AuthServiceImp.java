package com.jalach.jalach.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jalach.jalach.models.Company;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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
    public boolean validateCompanyByRut(Integer rut) {
        String query = "FROM Company WHERE rut = :rut";
        List<Company> matchCompany = entityManager.createQuery(query, Company.class).setParameter("rut", rut).getResultList();
        return !matchCompany.isEmpty();
    }

    @Override
    public Company registerCompany(Company company) {
        return entityManager.merge(company);
    }

    @Override
    public Company loginCompany(Company company) {
        String query = "FROM Company WHERE user = :user";
        List<Company> matchCompany = entityManager.createQuery(query, Company.class).setParameter("user", company.getUser()).getResultList();

        if(matchCompany.isEmpty()){
            return null;
        }

        String passwordHased = matchCompany.get(0).getPassword();
        char [] passwordCompany = company.getPassword().toCharArray();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHased, passwordCompany)){
            return matchCompany.get(0);
        }

        return null;
    }
    
}
