package com.jalach.jalach.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jalach.jalach.models.Role;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class RoleServiceImp implements RoleService {


    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Role createRole(Role role) {
        return entityManager.merge(role);
    }

    @Override
    public List<Role> getRolesOf(Integer rut) {
        String query = "FROM Role WHERE business_rut = :rut";
        return entityManager.createQuery(query, Role.class)
                .setParameter("rut", rut)
                .getResultList();
    }

    @Override
    public boolean deleteRole(Integer id) {
        Role role = entityManager.find(Role.class, id);
        if(role != null){
            entityManager.remove(role);
            return true;
        }
        return false;
    }
    
}
