package com.adminservice.main.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adminservice.main.entity.EmployeeLeaves;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeaves, String> {
	
//	    Optional<EmployeeLeaves> findByGuid(String Guid);
	    Optional<EmployeeLeaves> findByGuid(String guid);


	    
}
