package com.jalach.jalach.controllers;

import java.util.List;

import com.jalach.jalach.models.Employee;
import com.jalach.jalach.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class EmployeeController {
 
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value="/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping(value = "/employees/company/{rut}")
    public List<Employee> getEmployeesOfCompany(@PathVariable Integer  rut){
        return employeeService.getEmployeesOfCompany(rut);
    }

    @GetMapping(value = "/employees/roles/{role}")
    public List<Employee> getGetEmployeesOfRole(@PathVariable Integer  role){
        return employeeService.getEmployeesOfRole(role);
    }
    
    @PostMapping(value="/employees")
    public Employee hireEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.hireEmployee(employee);
        return newEmployee;
    }

    @PutMapping(value="/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping(value="/employees/{id}")
    public Employee dismissEmployee(@PathVariable Integer id){
        return employeeService.dismissEmployee(id);    
    }
}
