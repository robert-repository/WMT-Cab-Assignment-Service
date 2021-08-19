package com.walmart.cabassignmentservice.service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.walmart.cabassignmentservice.model.DriverCab;
import com.walmart.cabassignmentservice.service.DriverCabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private DriverCabService driverCabService;

    @KafkaListener(topics = "cab_location", groupId = "group_id", containerFactory = "kafkaListener")
    public void consumeJson(DriverCab driverCab) throws JsonProcessingException {
        //Saving driver cab here....

        DriverCab driverCab2 = driverCabService.createDriverCab(driverCab);

    }

}
