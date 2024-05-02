package com.adminservice.main.service;

import java.util.List;

import org.springframework.amqp.core.Message;

import com.adminservice.main.dto.EmployeeLeaveDto;
import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.helperclasses.ResponseMsg;

public interface AdminService {

     ResponseMsg empregister(RegistrationdDTO registrationDTO);

	 String DeleteUserById(String gmail);
		
	 List<Employee> getAllEmployees();

	 Employee getEmployeeByGmail(String gmail);

	void receiveLeaveRequest(Message message);

	 
	 
	 
}
