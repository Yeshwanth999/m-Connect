 package com.adminservice.main.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.entity.User;
import com.adminservice.main.helperclasses.ResponseMsg;
import com.adminservice.main.repository.AdminRepository;
import com.adminservice.main.repository.EmployeeLeaveRepository;
import com.adminservice.main.repository.UserRepo;


@Service
@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepo; // Employee data

	@Autowired
	private UserRepo emprepo; // Employee login data

	public AdminServiceImpl(AdminRepository adminrepo) {
		this.adminrepo = adminrepo;
	}

	@Autowired
	private EmployeeLeaveRepository empleaveleaverepo;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	private static final String FILENAME = "src/main/resources/static/counter.txt";

	public static String generateID() {
		int counter = readCounterFromFile();
		StringBuilder idBuilder = new StringBuilder();
		idBuilder.append("SP2515788-M");
		idBuilder.append(String.format("%04d", counter)); // Ensures the numerical part has at least 4 digits
		updateCounterInFile(counter + 1);
		return idBuilder.toString();
	}
	
	private static int readCounterFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String line = br.readLine();
			if (line != null) {
				return Integer.parseInt(line.trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 1; // Default value if file doesn't exist or couldn't be read
	}

	private static void updateCounterInFile(int counter) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
			bw.write(Integer.toString(counter));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResponseMsg empregister(RegistrationdDTO registerEmp) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encrypetedPwd = bcrypt.encode(registerEmp.getPassword());
		registerEmp.setPassword(encrypetedPwd);

		Employee emp = new Employee();
		emp.setGuid(generateID());
		emp.setGmail(registerEmp.getGmail());
		emp.setPassword(encrypetedPwd);
		emp.setBlood_group(registerEmp.getBlood_group());
//		emp.setAdmin(true);
		emp.setAdminStatus(registerEmp.isAdminStatus());
		emp.setCurrentPincode(registerEmp.getCurrentPincode());
		emp.setCurrentAddress(registerEmp.getCurrentAddress());
		emp.setCurrentCity(registerEmp.getCurrentCity());
		emp.setCurrentCountry(registerEmp.getCurrentCountry());
		emp.setCurrentPincode(registerEmp.getCurrentPincode());
		emp.setCurrentState(registerEmp.getCurrentState());
		emp.setDob(registerEmp.getDob());
		emp.setFirstname(registerEmp.getFirstname());
		emp.setLastname(registerEmp.getLastname());
		emp.setGender(registerEmp.getGender());
		emp.setLivingincurrent(registerEmp.getLivingincurrent());
		emp.setMarital_status(registerEmp.getMarital_status());
		emp.setStayingsince(registerEmp.getStayingsince());
		emp.setPermanentAddress(registerEmp.getPermanentAddress());
		emp.setPermanentCity(registerEmp.getPermanentCity());
		emp.setPermanentCountry(registerEmp.getPermanentCountry());
		emp.setPermanentPincode(registerEmp.getPermanentPincode());
		emp.setPermanentState(registerEmp.getPermanentState());
		emp.setPhonenumber(registerEmp.getPhonenumber());
		emp.setRole(registerEmp.getRole());
		emp.setStayingsince(registerEmp.getStayingsince());

		User user = new User();
		BeanUtils.copyProperties(emp, user);
		emprepo.save(user);
		adminrepo.save(emp);

		return new ResponseMsg(true, emp.getFirstname(), "Employee Added Succesfully.");
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emp = adminrepo.findAll();
		return emp;
	}

	@Override
	public Employee getEmployeeById(Long id) {

		Optional<Employee> emp = adminrepo.findById(id);

		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	@Override
	public String DeleteUserById(long id) {
		adminrepo.deleteById(id);
//		userrepo.deleteAll();
		return "User Data Droped";
	}

//	@Override
//	public void sendApprovalNotification(EmployeeLeaveDto empLeaveDto) {
//		String url = "http://user-service-hostname:port/employeeLeave/{guid}";
//
//		ResponseEntity<EmployeeLeaveDto> responseEntity = restTemplate.getForEntity(url, EmployeeLeaveDto.class, guid);
//
//		EmployeeLeaveDto empLeaveDto = responseEntity.getBody();
//
//		System.out.println("Approval notification sent for employee leave: " + employeeLeave.getId());
//	}

//	@RabbitListener(queues = "${spring.rabbitmq.queue}")
//	public void receiveMessageFromUserQueue(String message) {
//
//		System.out.println("Admin Service received message from user queue: " + message);
//		// Process the received message as needed
//	}
//	
//	@RabbitListener(queues = "${spring.rabbitmq.leaveQueue}")
//	public void receiveLeaveRequest(EmployeeLeaves empLeaveDto) {
//		System.out.println("Admin Service received Leave Request from RabbitMQ: " + empLeaveDto.getGuid());
//
//		Employee employee = new Employee();
//
//		if (employee.getGmail().equals(empLeaveDto.getAdmingmail()) && employee.isAdminStatus() == true) {
//
//			receiveUserDetails(empLeaveDto.getGuid());
//
//			sendLeaveinfoStatus(empLeaveDto.getGuid());
//		}
//	}
//
//	@RabbitListener(queues = "${spring.rabbitmq.userDetailsQueue}")
//	public void receiveUserDetails(String guid) {
//		
//		try{
//			System.out.println("Admin Service received User Details Request from RabbitMQ: " + guid);
//		
//		EmployeeLeaves empleaveDetails = getEmployeeDetailsWithLeaveInfo(guid);
//
//		rabbitTemplate.convertAndSend("exchangeName", "user.details.routingKey", empleaveDetails);
//	} catch (Exception e) {
//        System.err.println("Error processing message from RabbitMQ: " + e.getMessage());
//        e.printStackTrace();
//    }
//		
//	}
//
//	private EmployeeLeaves getEmployeeDetailsWithLeaveInfo(String guid) {
//
//		Optional<EmployeeLeaves> employeeDetails = empleaveleaverepo.findByGuid(guid);
//
//		if (employeeDetails.isPresent()) {
//			return employeeDetails.get();
//		} else {
//			return null;
//		}
//
//	}
//	
//	@RabbitListener(queues = "${spring.rabbitmq.approveQueue}")
//	private void sendLeaveinfoStatus(String guid) {
//         
//		EmployeeLeaveDto empdto = new EmployeeLeaveDto();
//		 Optional<EmployeeLeaves> employeeDetails = empleaveleaverepo.findByGuid(guid);
//		
//		if (employeeDetails.isPresent()){
//		
//			EmployeeLeaves employeeLeave = employeeDetails.get();		  
//			employeeLeave.setNo_of_days_approved(empdto.getNo_of_days_approved());
//            employeeLeave.setLeaveStatus(empdto.getLeaveStatus());
//		}
//    
//	}
//	
	
}
