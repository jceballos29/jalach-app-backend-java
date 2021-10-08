package com.jalach.jalach.controllers;

import java.util.List;

import com.jalach.jalach.models.Role;
import com.jalach.jalach.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping(value = "/api/v1")
public class RoleController {
    
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/roles")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @GetMapping(value = "/roles/{rut}")
    public List<Role> getRolesOf(@PathVariable Integer rut){
        return roleService.getRolesOf(rut);
    }

    @DeleteMapping(value = "/roles/{id}")
    public String deleteRole(@PathVariable Integer id){
        if(roleService.deleteRole(id)){
            return "Deleted";
        }
        return "Failed";
    }
}
