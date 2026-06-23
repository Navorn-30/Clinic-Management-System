package com.navorn.clinic_management.service;

import com.navorn.clinic_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    // Must have Add, Update, Delete, FindByID, FindAll
    void printCustomerInfo();
    List<Customer> findAllCustomers();
    Customer addNewCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Long id);
    Customer deleteCustomer(Long id);
    Customer findByID(Long id);
}
