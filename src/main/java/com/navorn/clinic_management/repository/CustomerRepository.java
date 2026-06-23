package com.navorn.clinic_management.repository;

import com.navorn.clinic_management.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

// Repository work with Database

@Repository
// CrudRepository is build in extend class in spring data jdbc
// for <class in package model, datatype of primary key>
public interface CustomerRepository extends ListCrudRepository<Customer,Long> {
    // Methods derivation
    // Methods that auto create when we use CrudRepository or ListCrudRepository

    // Use ListCrudRepository because it will return value as List to can use in get all record from database
}
