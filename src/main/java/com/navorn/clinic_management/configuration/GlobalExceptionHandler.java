package com.navorn.clinic_management.configuration;

import com.navorn.clinic_management.exception.MethodArgumentNotValidExceptions;
import com.navorn.clinic_management.exception.RecordNotFoundException;
import com.navorn.clinic_management.utils.ApiResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
// Use to register exception to IoC container
public class GlobalExceptionHandler {
    // Object is the biggest class in Java
    // Object class can handle every type of data and value that what to store
    // Object class is not same as Object that extends from blueprint
    @ExceptionHandler(RecordNotFoundException.class)
    // It will work when have try-catch or exception it will show this block code to frontend
    public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex){
        // Map is uses to store key-value
        // First String use to store key
        // Second String use to store value
//        Map<String, String> map = new HashMap<>();
//        // ex.getMessage() is get from RecordNotFoundException class
//        map.put("message", ex.getMessage());
//        map.put("data", null);
//        map.put("timestamp", new Date().toString());
//        map.put("statusCode", HttpStatus.NOT_FOUND.toString());
//        // Use like that to return same as datatype of method
//        return ResponseEntity.ok(map);

        return ApiResponseStructure.singleResponse(ex.getMessage(), null, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // Handle Method not argument valid exception
    public ResponseEntity<Object> handleValidException(MethodArgumentNotValidException ex){
        Map<String, String> map = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                err -> map.put(err.getField(), err.getDefaultMessage())
        );
        return ApiResponseStructure.errorResponse(ex.getMessage(), map, HttpStatus.BAD_REQUEST);
    }
}
