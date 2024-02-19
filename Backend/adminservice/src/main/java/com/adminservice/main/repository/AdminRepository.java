package com.adminservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminservice.main.entity.Employee;

@Repository
public interface AdminRepository extends JpaRepository<Employee, Long> {

//	 void save(Employee emp);

}
