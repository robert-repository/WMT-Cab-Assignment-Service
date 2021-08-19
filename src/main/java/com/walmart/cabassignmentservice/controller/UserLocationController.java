package com.walmart.cabassignmentservice.controller;


import com.walmart.cabassignmentservice.model.Users;
import com.walmart.cabassignmentservice.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/locations")
public class UserLocationController {

    @Autowired
    private UserLocationService userLocationService;

    @PostMapping
    public ResponseEntity<?> createUserLocation(@RequestBody Users user){
        try{
            return new ResponseEntity<Users>(userLocationService.createUserLocation(user), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
