package com.navorn.clinic_management.service;

import com.navorn.clinic_management.domain_transter_object.RoleDTO;
import com.navorn.clinic_management.model.Role;
import org.springframework.data.domain.Page;

public interface IRoleService {
    // Return as roleDTO, when insert role to db and it will respond back RoleDTO
    RoleDTO addNewRole(Role role);
    RoleDTO updateRole(Long Id, Role role);
    RoleDTO deleteRole(Long Id);
    // Keyword use to search
    Page<RoleDTO> findAllRoles(int page, int size, String keyword);
    Page<RoleDTO> findAllActiveRoles(int page, int size, String keyword);
    RoleDTO activateRole(int status, Long id);

}
