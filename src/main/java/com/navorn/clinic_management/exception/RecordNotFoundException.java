package com.navorn.clinic_management.exception;

public class RecordNotFoundException extends RuntimeException{
    // Create constructor by using generate
    public RecordNotFoundException(String message) {
        super(message);
    }

}
