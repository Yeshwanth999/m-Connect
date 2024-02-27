package com.userservice.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.main.entity.EmployeeLeave;


public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
	
	    Optional<EmployeeLeave> findById(Long id);
	
}
