package com.navorn.clinic_management.service.implement;

import com.navorn.clinic_management.exception.RecordNotFoundException;
import com.navorn.clinic_management.model.Customer;
import com.navorn.clinic_management.repository.CustomerRepository;
import com.navorn.clinic_management.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.lang.Long;

import java.util.Date;
import java.util.List;

@Service
// Purpose : for inject to controller
public class CustomerService implements ICustomerService {

    // Dependency Injection
    public final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository _customerRepository){
        this.customerRepository = _customerRepository;
    }

    @Override
    public void printCustomerInfo() {
        System.out.println("This is customer info.......");
    }

    @Override
    public Page<Customer> findAllCustomers(int page, int size) {
//        return List.of(
//                new Customer(1L, "Jonh Doe"),
//                new Customer(2L, "Alice")
//        );
        // Find all or return all record from Database;
//        List<Customer> customerList  =customerRepository.findAll();
//        return customerList;

        // Build in function in Pagination to tell spring data about page and size
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> objCustomer = customerRepository.findAll(pageable);
        return objCustomer;
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        // .save is a build-in method in CrudRepository
        customer.setStatus(1);
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        Customer cus = customerRepository.save(customer);
        return cus;
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        // use setId to tell customer that we update the customer info
        // If we not use setId it mean that create new customer
        customer.setId(id);
        customer.setUpdatedAt(new Date());
        Customer cus = customerRepository.save(customer);
        return cus;
        // save

    }

    @Override
    public Customer deleteCustomer(Long id) {
        // Handle to show what record that we delete show it in frontend
        Customer recordToDelete = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return recordToDelete;
    }

    @Override
    public Customer findByID(Long id) {
//        Customer cus = customerRepository.findById(id).get();
//        return cus
//        // If record cannot find we use orElseThrow to handle exception;
        Customer cus = customerRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("Customer ID : " + id + " not Found.....")
        );
        return cus;
    }
}
