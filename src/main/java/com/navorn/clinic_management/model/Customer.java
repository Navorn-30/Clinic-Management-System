package com.navorn.clinic_management.model;

import jakarta.persistence.Table;

@Table(name = "customer")
public class Customer {
    private Long id;
    private String customerName;
    private String gender;
    private String telephone;
    private String dob;

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

    public Customer(Long id, String customerName){
        this.id = id;
        this.customerName = customerName;
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
