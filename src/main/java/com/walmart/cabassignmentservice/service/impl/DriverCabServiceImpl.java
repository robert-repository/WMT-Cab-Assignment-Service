package com.walmart.cabassignmentservice.service.impl;

import com.walmart.cabassignmentservice.model.DriverCab;
import com.walmart.cabassignmentservice.model.Response;
import com.walmart.cabassignmentservice.repo.DriverCabRepo;
import com.walmart.cabassignmentservice.service.DriverCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DriverCabServiceImpl implements DriverCabService {

    @Autowired
    private DriverCabRepo driverCabRepo;

    @Override
    public DriverCab createDriverCab(DriverCab driverCab) {
        return driverCabRepo.save(driverCab);
    }

    @Override
    public List<Response> findNearestCabs(String locations, int cabs) {

        List<DriverCab> driverCabs =
                driverCabRepo.findAll();
//                        .stream().filter(e -> e.getGeoLocation().getId().equals(locations)).collect(Collectors.toList());

        System.out.println("I am here ...."+ driverCabs.size()+ "Locations ==>"+locations);
        Map<String, Double> cabsDistance = new HashMap<>();
        List<Response> responses = new ArrayList<>();
        for (DriverCab cab : driverCabs) {
            if(cab.getGeoLocation().getId().equals(locations)) {
                double distance = Math.sqrt(Math.pow(cab.getGeoLocation().getLatitude(), 2) + Math.pow(cab.getGeoLocation().getLongitude(), 2));
                cabsDistance.put(cab.getCabId(), distance);
            }
        }

        cabsDistance.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> cabsDistance.put(x.getKey(), x.getValue()));

        Iterator hmIterator = cabsDistance.entrySet().iterator();

        while (hmIterator.hasNext() && responses.size()< cabs) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            Response response = new Response(mapElement.getKey().toString());
            responses.add(response);
        }

        return responses;
    }
}
