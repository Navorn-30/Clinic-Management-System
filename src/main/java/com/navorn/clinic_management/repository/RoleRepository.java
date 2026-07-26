package com.navorn.clinic_management.repository;

import com.navorn.clinic_management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Work with db
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
