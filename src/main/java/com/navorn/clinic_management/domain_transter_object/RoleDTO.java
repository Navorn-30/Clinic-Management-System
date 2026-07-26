package com.navorn.clinic_management.domain_transter_object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private String roleName;
    private String roleDescription;
    private int status;
    private String uuid;
}
