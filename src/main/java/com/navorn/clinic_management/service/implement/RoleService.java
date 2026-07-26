package com.navorn.clinic_management.service.implement;


import com.navorn.clinic_management.domain_transter_object.RoleDTO;
import com.navorn.clinic_management.exception.RecordNotFoundException;
import com.navorn.clinic_management.mapper.RoleMapper;
import com.navorn.clinic_management.model.Role;
import com.navorn.clinic_management.repository.RoleRepository;
import com.navorn.clinic_management.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoleService implements IRoleService {

    // Injection Dependency
    @Autowired
    public RoleRepository roleRepository;

    @Override
    public RoleDTO addNewRole(Role role) {
//        Role obj = roleRepository.save(role);
//        RoleDTO roleDTO = RoleMapper.convertEntityToDTO(obj);
//        return roleDTO;
        // or shortcut
        role.setStatus(1);
        role.setUuid(UUID.randomUUID().toString());
        role.setUpdatedAt(new Date());
        role.setCreatedAt(new Date());
        return RoleMapper.convertEntityToDTO(roleRepository.save(role));
    }

    @Override
    public RoleDTO updateRole(Long Id, Role role) {
        // Exception
        Role r = roleRepository.findById(Id).orElseThrow( () -> {
            throw new RecordNotFoundException("Role not found with ID : " + Id);
        });

        r.setRoleName(role.getRoleName());
        r.setRoleDescription(role.getRoleDescription());

        role.setId(Id); // Id that pass from frontend
        Role result = roleRepository.save(role);
        return RoleMapper.convertEntityToDTO(result);
    }

    // Use datatype RoleDTO because it will show or return record that we delete
    @Override
    public RoleDTO deleteRole(Long Id) {
        Role result = roleRepository.findById(Id).orElseThrow(() -> {
            throw new RecordNotFoundException("Role not found with ID : " + Id);
        });
        roleRepository.deleteById(Id);
        return RoleMapper.convertEntityToDTO(result);
    }

    @Override
    public Page<RoleDTO> findAllRoles(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Role> roles = roleRepository.findAll(pageable);
        // Extract Role entity to dto list by mapper
        List<RoleDTO> dtoList = roleRepository.findAll(pageable).getContent().stream().map(RoleMapper::convertEntityToDTO).toList();
        // And then Add list make it match return type
        Page<RoleDTO> dtoPage = new PageImpl<>(dtoList, roles.getPageable(), roles.getTotalElements());
        return dtoPage;
    }

    @Override
    public Page<RoleDTO> findAllActiveRoles(int page, int size, String keyword) {
        return null;
    }

    @Override
    public RoleDTO activateRole(int status, Long id) {
        Role result = roleRepository.findById(id).orElseThrow(() -> {
           throw new RecordNotFoundException("Role Not found with id : " + id);
        });
        int statusToggle = status;
        result.setStatus(statusToggle);
        result.setId(id);
        Role obj = roleRepository.save(result);
        return RoleMapper.convertEntityToDTO(obj);
    }
}
