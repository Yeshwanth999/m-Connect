package com.userservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.main.entity.Employee;
import com.userservice.main.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByGmail(String email);

	Employee save(Employee employee);
	
}

