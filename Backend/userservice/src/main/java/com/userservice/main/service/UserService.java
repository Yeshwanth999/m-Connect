package com.userservice.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.userservice.main.entity.Employee;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.RegistrationDto;


public interface UserService {
	
//      UserEntity save(RegistrationDto registrationDTO);

	   String userLogin(LoginForm loginForm);
      
	   String addUser(RegistrationDto user);

	   Employee saveEmployee(Employee employee);

	   List<Employee> getAllEmployees();

	   Employee getEmployeeById(Long id);

	  String forgotPassword(LoginForm loginform);

	  boolean getOtp(String gmail, String otp);

	  String setpassword(String gmail, String password);

	   String DeleteUserById(long id);

	  

	  
      
	   
      

}
