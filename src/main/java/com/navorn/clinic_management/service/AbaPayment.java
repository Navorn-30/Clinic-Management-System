package com.navorn.clinic_management.service;

public class AbaPayment implements PaymentGateway{

    @Override
    public void pay(double amount) {
        System.out.println("ABA Payment $ " + amount);
    }
}
