package com.adminservice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adminservice.main.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {

	
}
