package com.navorn.clinic_management.controller;

import com.navorn.clinic_management.model.Customer;
import com.navorn.clinic_management.service.implement.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    // Dependency injection
    public CustomerService customerService;
    public CustomerController(CustomerService _customerService){
        this.customerService = _customerService;
    }

    // This is default path
    @GetMapping(path = "/")
    // RequestParam use to get request param from frontend
    public String index(@RequestParam(name = "cid") String cid, @RequestParam(name = "name") String name){
        return "Customer ID : " + cid + "\n" + "Customer Name : " + name;
    }

//    // Find all customer
//    @GetMapping(path = "/")
//    public List<Customer> findAllCustomer(){
//        List<Customer> customerList = customerService.findAllCustomers();
//        return customerList;
//    }

    // It means when frontend request from localhost://8080/api/v1/customers/hello_world
    // -> it will get "Hello World"
//    @GetMapping(path = "/hello_world")
    @RequestMapping(path = "/hello_world", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/getCustomerName")
    public String getCustomerName(){
        return "Customer Name";
    }
}
