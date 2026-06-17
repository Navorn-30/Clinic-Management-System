package com.navorn.clinic_management.service.implement;

import com.navorn.clinic_management.model.Customer;
import com.navorn.clinic_management.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Purpose : for inject to controller
public class CustomerService implements ICustomerService {
    @Override
    public void printCustomerInfo() {
        System.out.println("This is customer info.......");
    }

    @Override
    public List<Customer> findAllCustomers() {
        return List.of(
                new Customer(1L, "Jonh Doe"),
                new Customer(2L, "Alice")
        );
    }
}
