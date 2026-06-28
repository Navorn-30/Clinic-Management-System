package com.navorn.clinic_management.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Use to response format to Frontend
public class ApiResponseStructure {
    public static ResponseEntity<Object> singleResponse(String message, Object objectResponse, HttpStatus httpStatus){
        Map<String, Object> map = new HashMap<>();
        // ex.getMessage() is get from RecordNotFoundException class
        map.put("message", message);
        map.put("data", objectResponse);
        map.put("timestamp", new Date().toString());
        map.put("statusCode", httpStatus);
        return new ResponseEntity<Object>(map,httpStatus);
    }
    // When we use it, we use static
    // ApiResponseStructure.singleResponse(?,?,?)
}
