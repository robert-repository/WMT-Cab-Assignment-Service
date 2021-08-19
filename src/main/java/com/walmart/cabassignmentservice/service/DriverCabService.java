package com.walmart.cabassignmentservice.service;

import com.walmart.cabassignmentservice.model.DriverCab;
import com.walmart.cabassignmentservice.model.Response;

import java.util.List;
import java.util.Map;

public interface DriverCabService {

    public DriverCab createDriverCab(DriverCab driverCab);

    public List<Response> findNearestCabs(String locations, int cabs);
}
