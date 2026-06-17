package com.navorn.clinic_management.controller;

import com.navorn.clinic_management.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    // It means that paymentService can use in the whole PaymentController Class
    @Autowired
    public PaymentService paymentService;

    @GetMapping(path = "/")
    public String abc(){
        return "Hello";
    }



    // Inject by constructor
//    public PaymentController(PaymentService obj){
//        this.obj = obj;
//    }

    // Purpose for using in the whole controller
}
