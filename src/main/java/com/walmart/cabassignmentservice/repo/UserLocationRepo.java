package com.walmart.cabassignmentservice.repo;

import com.walmart.cabassignmentservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationRepo extends JpaRepository<Users, Long> {

}
