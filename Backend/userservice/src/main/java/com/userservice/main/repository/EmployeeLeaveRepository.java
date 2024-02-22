package com.userservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.main.entity.EmployeeLeave;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {

}
