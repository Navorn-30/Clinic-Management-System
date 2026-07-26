package com.navorn.clinic_management.mapper;

import com.navorn.clinic_management.domain_transter_object.RoleDTO;
import com.navorn.clinic_management.model.Role;
import org.springframework.beans.BeanUtils;

public class RoleMapper {
    // 2 function mapper
    // A. Map Entity -> DTO
    // B. Map DTO -> Entity

    // Convert get RoleDTO
    // Use role to convert (parameter)
    // Use to custom DTO
    public static RoleDTO convertEntityToDTO(Role role){
        RoleDTO dto = new RoleDTO();
        BeanUtils.copyProperties(role, dto);
        return dto;
        // The result is return 3 fields in dto
    }

    public static Role convertDTOToEntity(RoleDTO dto){
        // Create object to get or offer it
        Role role = new Role();
        BeanUtils.copyProperties(dto, role);
        return role;
    }
}
// How to call :
    // RoleMapper obj = new RoleMapper();
    // obj.conver....
// --> RoleMapper.conver.......   -> use keyword static
