package com.navorn.clinic_management.model;

//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

// When we use @Table like that it mean that java class much mapping with table database name customer
// But we need to create table in database by my self cuz JDBC not support auto create table
@Table(name = "bit_customers")
public class Customer {
    @Id
    private Long id;
    private String customerName;
    private String gender;
    private String telephone;
    private String dob;
    private int status;
//    @Column("created_at")
    private Date createdAt;
//    @Column("updated_at")
    private Date updatedAt;

    public Customer(){
//        this.status = 1;
//        this.createdAt = new Date();
//        this.updatedAt = new Date();
    }

    public Customer(Long id, String customerName){
        this.id = id;
        this.customerName = customerName;
    }
    public Customer(Long id, String customerName, String gender, String telephone, String dob){
        this.id = id;
        this.customerName = customerName;
        this.gender = gender;
        this.telephone = telephone;
        this.dob = dob;
        this.status = 1;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
//    public Customer(){
//
//    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getGender() {
        return gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getDob() {
        return dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString(){
        return "Customer{" +
                "id = " + id +
                ", customerName ='" + customerName + '\''+
                ", gender = '" + gender + '\'' +
                ", telephone = '" + telephone + '\'' +
                ", dob = '" +  dob + '\'' +
                '}';
    }
}
