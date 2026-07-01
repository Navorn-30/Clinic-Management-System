package com.navorn.clinic_management.utils;

import org.springframework.data.domain.Page;
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
        map.put("statusCode", httpStatus.value());
        return new ResponseEntity<Object>(map,httpStatus);
    }
    // When we use it, we use static
    // ApiResponseStructure.singleResponse(?,?,?)


    // create error exception
    public static ResponseEntity<Object> errorResponse(String msg, Object objectResponse, HttpStatus httpStatus){
        Map<String, Object> map = new HashMap<>();
        map.put("errors", objectResponse);
        map.put("timestamp", new Date().toString());
        map.put("statusCode", httpStatus.value());
        return new ResponseEntity<Object>(map,httpStatus);
    }

    // Multiple Response
    public static ResponseEntity<Object> multipleResponse(String msg, Page<Object> pagiResponse){
        Map<String, Object> map = new HashMap<>();
        // Design pagination
        // all pagiMap are manage by map.put("data", pagiMap)
        Map<String, Object> pagiMap = new HashMap<>();
        pagiMap.put("totalPages", pagiResponse.getTotalPages());
        pagiMap.put("totalElements", pagiResponse.getTotalElements());
        pagiMap.put("items", pagiResponse.getContent());
        map.put("message", msg);
        map.put("data", pagiMap);
        map.put("timestamp", new Date().toString());
        map.put("statusCode", HttpStatus.OK.value());
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }
}
