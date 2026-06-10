package com.navorn.clinic_management.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// When we use @Service it means that we can reuse that class in our whole project by injection
// It is a Service Class
@Service
public class PaymentService {
    // We use like that because PaymentGateway already create and register to IoC
    // PaymentGateway of Bean not interface
    public PaymentGateway _paymentGateway;

    public PaymentService(@Qualifier("abaGateway") PaymentGateway pg){
        _paymentGateway = pg;
    }

    public void processPayment(double amount){
        _paymentGateway.pay(amount);
    }
    // Purpose is to use _paymentGateway in the whole services
}
