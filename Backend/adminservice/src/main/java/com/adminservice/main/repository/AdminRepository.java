package com.adminservice.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adminservice.main.entity.Employee;

@Repository
public interface AdminRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByGmail(String gmail);

	void deleteByGmail(String gmail);

//	 void save(Employee emp);

}
