package com.navorn.clinic_management.configuration;

import com.navorn.clinic_management.service.AbaPayment;
import com.navorn.clinic_management.service.AcledaPayment;
import com.navorn.clinic_management.service.PaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Use this annotation, when we add bean all bean will go to IoC
// Use @Configuration it will Register all bean to IoC
@Configuration
public class PaymentConfig {

    @Bean("abaGateway")
    public PaymentGateway abaGateway(){
        return new AbaPayment();
        // PaymentGateway abaGateway = new AbaPayment();
    }

    @Bean("acledaGateway")
    public PaymentGateway acledaGateway(){
        return new AcledaPayment();
    }
}
