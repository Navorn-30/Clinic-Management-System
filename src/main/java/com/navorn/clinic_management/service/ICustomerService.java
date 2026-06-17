package com.navorn.clinic_management.service;

import com.navorn.clinic_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    void printCustomerInfo();
    List<Customer> findAllCustomers();
}
