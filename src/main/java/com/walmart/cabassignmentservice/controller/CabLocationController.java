package com.walmart.cabassignmentservice.controller;

import com.google.gson.Gson;
import com.walmart.cabassignmentservice.model.DriverCab;
import com.walmart.cabassignmentservice.model.Response;
import com.walmart.cabassignmentservice.service.DriverCabService;
import com.walmart.cabassignmentservice.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cabs")
public class CabLocationController {

    @Autowired
    KafkaTemplate<String, DriverCab> kafkaTemplate;
    private static final String topic="cab_location" ;

    @Autowired
    private DriverCabService driverCabService;

    @PostMapping("/publish")
    public String publish(@RequestBody DriverCab driverCab){
        kafkaTemplate.send(topic, driverCab);
        return "Published Successfully";
    }

    @GetMapping
    public List<Response> findNearestCab(@RequestParam("locations") String locations, @RequestParam("cabs") int cabs){
        return driverCabService.findNearestCabs(locations, cabs);
    }

}
