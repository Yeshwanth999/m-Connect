package com.userservice.main.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.main.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

//      	Optional<Employee> findByGuid(String guid);

		Optional<Employee> findByGmail(String gmail);

		 

}
