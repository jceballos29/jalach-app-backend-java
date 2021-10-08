package com.jalach.jalach.services;

import java.util.List;

import com.jalach.jalach.models.Employee;

public interface EmployeeService {
    
    Employee getEmployee(Integer id);
    List<Employee> getEmployeesOfCompany(Integer  rut);
    List<Employee> getEmployeesOfRole(Integer  role);
    Employee hireEmployee(Employee employee);
    Employee updateEmployee(Integer id, Employee updatedEmployee);
    Employee dismissEmployee(Integer id);
}
