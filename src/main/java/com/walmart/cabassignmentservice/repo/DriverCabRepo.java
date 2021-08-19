package com.walmart.cabassignmentservice.repo;

import com.walmart.cabassignmentservice.model.DriverCab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverCabRepo extends JpaRepository<DriverCab, Long> {
}
