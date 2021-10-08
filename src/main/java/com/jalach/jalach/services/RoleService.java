package com.jalach.jalach.services;

import java.util.List;

import com.jalach.jalach.models.Role;

public interface RoleService {
    
    Role createRole(Role role);
    List<Role> getRolesOf(Integer rut);
    boolean deleteRole(Integer id);
}
