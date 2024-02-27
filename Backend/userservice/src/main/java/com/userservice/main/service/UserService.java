package com.userservice.main.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.userservice.main.entity.Employee;
import com.userservice.main.entity.EmployeeLeave;
import com.userservice.main.registration.dto.EmployeeLeaveDto;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.RegistrationDto;
import com.userservice.main.registration.dto.ResponseMsg;


public interface UserService {
	
//      UserEntity save(RegistrationDto registrationDTO);

	   String userLogin(LoginForm loginForm);
      
//	   String addUser(RegistrationDto user);

	   Employee saveEmployee(Employee employee);

	   List<Employee> getAllEmployees();

	   Employee getEmployeeById(Long id);

	  String forgotPassword(LoginForm loginform);

	  boolean getOtp(String gmail, String otp);

	  String setpassword(String gmail, String password);

	  EmployeeLeave applyLeave(EmployeeLeave employeeLeave);
	  
		ResponseMsg updateEmp(String Guid, RegistrationDto registrationDTO);

		UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException;

//		String deleteemp(String guid);

		String DeleteUserById(long id);

		ResponseMsg saveLeaveDetails(Long id, EmployeeLeaveDto empDto);




	  

	  
      
	   
      

}
