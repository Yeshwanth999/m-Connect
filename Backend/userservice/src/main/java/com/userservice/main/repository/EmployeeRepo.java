package com.userservice.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.main.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {



}
