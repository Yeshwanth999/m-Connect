package com.userservice.main.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.userservice.main.entity.Employee;
import com.userservice.main.entity.EmployeeLeave;
import com.userservice.main.registration.dto.EmpAttandenceDto;
import com.userservice.main.registration.dto.EmployeeLeaveDto;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.RegistrationDto;
import com.userservice.main.registration.dto.ResponseMsg;

@Service
public interface UserService {

//      UserEntity save(RegistrationDto registrationDTO);

	String userLogin(LoginForm loginForm);

//	   String addUser(RegistrationDto user);

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String gmail);

	String forgotPassword(LoginForm loginform);

	boolean getOtp(String gmail, String otp);

	String setpassword(String gmail, String password);
	
	ResponseMsg updateEmp(String gmail, RegistrationDto registrationDTO);

	UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException;

//		String deleteemp(String guid);

	String DeleteUserById(String gmail);

	ResponseMsg saveLeaveDetails(String gmail, EmployeeLeaveDto empDto);

	ResponseMsg saveattendence(String gmail, EmpAttandenceDto empattandenceDto);

	String addImage(String gmail, MultipartFile file);

	ResponseEntity<Resource> getProfileImage(String gmail);

	String deleteRecord(String guid);


	
	
    }
