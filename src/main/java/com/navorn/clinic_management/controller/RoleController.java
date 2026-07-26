package com.navorn.clinic_management.controller;

import com.navorn.clinic_management.domain_transter_object.RoleDTO;
import com.navorn.clinic_management.model.Role;
import com.navorn.clinic_management.service.implement.RoleService;
import com.navorn.clinic_management.utils.ApiResponseStructure;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService _roleService){
        this.roleService = _roleService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> addNew (@Valid @RequestBody Role role){
        RoleDTO obj = roleService.addNewRole(role);
        return ApiResponseStructure.singleResponse("Adding new record Successfully....", obj, HttpStatus.CREATED);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Object> updateRole(@PathVariable Long Id, @Valid @RequestBody Role role){
        RoleDTO dto = roleService.updateRole(Id, role);
        return ApiResponseStructure.singleResponse("Update record successfully....", dto, HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long Id){
        RoleDTO obj = roleService.deleteRole(Id);
        return ApiResponseStructure.singleResponse("Delete record successfully", obj, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> findAllRoles(@RequestParam("page") int page, @RequestParam("size") int size, String keyword){
        Page<Object> objResult = roleService.findAllRoles(page, size, keyword).map(result -> (Object) result);
        return ApiResponseStructure.multipleResponse("List All Roles", objResult);
    }

    @PutMapping("/{status}/{Id}")
    public ResponseEntity<Object> activateRole (@PathVariable("status") int status, @PathVariable("Id") Long Id){
        RoleDTO dtoStatus = roleService.activateRole(status, Id);
        return ApiResponseStructure.singleResponse("Update status successfully...", dtoStatus,HttpStatus.OK);
    }
}
