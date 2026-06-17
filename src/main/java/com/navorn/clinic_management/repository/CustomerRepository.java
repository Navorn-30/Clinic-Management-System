package com.navorn.clinic_management.repository;

import com.navorn.clinic_management.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// CrudRepository is build in extend class in spring data jdbc
// for <class in package model, datatype of primary key>
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
