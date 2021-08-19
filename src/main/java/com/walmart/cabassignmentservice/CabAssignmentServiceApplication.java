package com.walmart.cabassignmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class CabAssignmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabAssignmentServiceApplication.class, args);
	}

}
