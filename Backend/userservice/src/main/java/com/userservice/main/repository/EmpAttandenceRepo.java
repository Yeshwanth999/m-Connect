package com.userservice.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.main.entity.EmpAttandence;

public interface EmpAttandenceRepo extends JpaRepository<EmpAttandence, Long> {

	Optional<EmpAttandence> findByGmail(String gmail);

	String deleteByGuid(String gmail);

}
