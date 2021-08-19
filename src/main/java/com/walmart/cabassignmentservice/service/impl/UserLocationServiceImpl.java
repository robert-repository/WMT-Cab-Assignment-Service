package com.walmart.cabassignmentservice.service.impl;

import com.walmart.cabassignmentservice.model.Users;
import com.walmart.cabassignmentservice.repo.UserLocationRepo;
import com.walmart.cabassignmentservice.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    @Autowired
    private UserLocationRepo userLocationRepo;

    @Override
    public Users createUserLocation(Users user) {
        return userLocationRepo.save(user);
    }
}
