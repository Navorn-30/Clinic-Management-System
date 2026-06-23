package com.navorn.clinic_management.controller;

import com.navorn.clinic_management.model.Customer;
import com.navorn.clinic_management.service.implement.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

//    // Dependency injection
//    public final CustomerService customerService;
//    public CustomerController(CustomerService _customerService){
//        this.customerService = _customerService;
//    }

    // This is testing
//    // This is default path
//    @GetMapping(path = "/")
//    // RequestParam use to get request param from frontend
//    public String index(@RequestParam(name = "cid") String cid, @RequestParam(name = "name") String name){
//        return "Customer ID : " + cid + "\n" + "Customer Name : " + name;
//    }



    // It means when frontend request from localhost://8080/api/v1/customers/hello_world
    // -> it will get "Hello World"
//    @GetMapping(path = "/hello_world")
//    @RequestMapping(path = "/hello_world", method = RequestMethod.GET)
//    public String helloWorld(){
//        return "Hello World";
//    }
//
//    @GetMapping(path = "/getCustomerName")
//    public String getCustomerName(){
//        return "Customer Name";
//    }

    // Use CrudRepository
    // This is what we want

    // Dependency injection
    public final CustomerService customerService;
    public CustomerController(CustomerService _customerService){
        this.customerService = _customerService;
    }

    // Add Record
    @PostMapping()
    public Customer addNewCustomer(@RequestBody Customer customer){
        Customer obj = customerService.addNewCustomer(customer);
        return obj;
    }

    // Find all customer
    @GetMapping(path = "/")
    public List<Customer> findAllCustomer(){
        List<Customer> customerList = customerService.findAllCustomers();
        return customerList;
    }

    @GetMapping("/{customerID}")
    public Customer findByID(@PathVariable("customerID") Long customerID){
        Customer cus = customerService.findByID(customerID);
        return cus;
    }

    @PutMapping(path = "/{customerID}")
    public Customer updateCustomer(@PathVariable("customerID") Long customerID, @RequestBody Customer objToUpdate){
        Customer cus = customerService.updateCustomer(objToUpdate, customerID);
        return cus;
    }

    @DeleteMapping(path = "/{customerID}")
    public Customer deleteCustomer(@PathVariable("customerID") Long customerID){
        return customerService.deleteCustomer(customerID);
    }
}
