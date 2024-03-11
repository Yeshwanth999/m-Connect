package com.userservice.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.main.entity.EmployeeLeave;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
	
	    Optional<EmployeeLeave> findByGuid(String Guid);
	    
 }
