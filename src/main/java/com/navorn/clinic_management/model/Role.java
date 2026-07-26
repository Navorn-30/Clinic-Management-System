package com.navorn.clinic_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity(name = "ent_role")
@Table(name = "bit_role")
@Data
// NoArgsConstructor must be deleted because we have created default constructor in Role class
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Add auto generate id
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_description")
    private String roleDescription;
    private int status;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    private String uuid;

    public Role(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.status = 1;
    }

    // This methods will get date from computer when user create
//    @PrePersist
//    protected void onCreated(){
//        uuid = UUID.randomUUID().toString();
//        status = 1; // 0,1,2
//        createdAt = new Date();
//        updatedAt = new Date();
//    }
//
//    @PreUpdate  // This method will get date from computer when user update
//    protected void onUpdate(){
//        updatedAt = new Date();
//    }
}
