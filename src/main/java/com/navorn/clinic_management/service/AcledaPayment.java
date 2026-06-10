package com.navorn.clinic_management.service;

public class AcledaPayment implements PaymentGateway{
    @Override
    public void pay(double amount) {
        System.out.println("Acleda Payment $" + amount);
    }
}

// Annotation -> Symbol