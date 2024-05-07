package com.adminservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adminservice.main.entity.EmpAttandence;



public interface EmpAttandenceRepo extends JpaRepository<EmpAttandence,Long> {

	void deleteByGmail(String gmail);
}
