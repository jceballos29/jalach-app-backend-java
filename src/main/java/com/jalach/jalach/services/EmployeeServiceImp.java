package com.jalach.jalach.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jalach.jalach.models.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeServiceImp implements EmployeeService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee hireEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        String query = "FROM Employee WHERE id = :id";
        return entityManager.createQuery(query, Employee.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Employee> getEmployeesOfCompany(Integer rut) {
        String query = "FROM Employee WHERE business_rut = :rut";
        return entityManager.createQuery(query, Employee.class).setParameter("rut", rut).getResultList();
    }

    @Override
    public List<Employee> getEmployeesOfRole(Integer role) {
        String query = "FROM Employee WHERE role_id = :role";
        return entityManager.createQuery(query, Employee.class).setParameter("role", role).getResultList();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null){
            return entityManager.merge(updatedEmployee);
        }
        return null;
    }

    @Override
    public Employee dismissEmployee(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null){
            entityManager.remove(employee);
            return employee;
        }
        return null;
    }
    
}
