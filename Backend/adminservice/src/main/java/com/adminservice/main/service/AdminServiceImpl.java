 package com.adminservice.main.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.adminservice.main.dto.EmployeeLeaveDto;
import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.entity.EmployeeLeaves;
import com.adminservice.main.entity.User;
import com.adminservice.main.helperclasses.ResponseMsg;
import com.adminservice.main.repository.AdminRepository;
import com.adminservice.main.repository.EmployeeLeaveRepository;
import com.adminservice.main.repository.UserRepo;
import com.adminservice.main.security.RabbitMQListener;



@Service
@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepo; // Employee data

	@Autowired
	private UserRepo emprepo; // Employee login data

	@Autowired
	private EmployeeLeaveRepository empleaveleaverepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);

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
      
		Optional<Employee> profileRegister = adminrepo.findByGmail(registerEmp.getGmail());
		
		if(profileRegister.isPresent()) {
			return new ResponseMsg(false, registerEmp.getGmail(), "This Email We have in our DataBase.");  
      }else {
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
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emp = adminrepo.findAll();
		return emp;
	}

	
	@Override
	 public Employee getEmployeeByGmail(String gmail) {
		
		Optional<Employee> emp = adminrepo.findByGmail(gmail);

		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}
	

	@Override
	public String DeleteUserById(String gmail) {
		adminrepo.deleteByGmail(gmail);
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
//    public void receiveMessageFromUserQueue(String message) {
//        System.out.println("Admin Service received message from user queue: " + message);
//        // Process the received message as needed
//    }
	
	public EmployeeLeaves getEmployeeDetailsWithLeaveInfo(String gmail) {
        return empleaveleaverepo.findByGmail(gmail).orElse(null);
    }
	
	
	@Override
	@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void receiveLeaveRequest(Message message) {
	    try {
	        String messageBody = new String(message.getBody());
	        LOGGER.info("Received message: " + messageBody);
	     
	    } catch (Exception ex) {
	        LOGGER.error("Error processing leave request: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	}
	
	
	
//	public void receiveLeaveRequest(Message message) {
//		
//		Optional<EmployeeLeaves> leavedata = empleaveleaverepo.findByGmail(message.getBody().getGmail());
//	    try {
//	    	EmployeeLeaveDto employeeLeaveDto= new EmployeeLeaveDto();
//	    	
//	    	employeeeLeaveDto.set
//	    	System.out.println("Admin Service received message from user queue: " + message);
//
//	        if (employeeLeaveDto != null) {
//	            System.out.println("Admin Service received Leave Request from RabbitMQ: " + employeeLeaveDto.getGuid());
//
//	            // Assuming Employee class and related logic
//	            Employee employee = new Employee();
//
//	            if (employee.getGmail().equals(employeeLeaveDto.getAdmingmail()) && employee.isAdminStatus()) {
//	                receiveUserDetails(employeeLeaveDto.getGuid());
//	                sendLeaveInfoStatus(employeeLeaveDto);
//	            }
//	        }
//	    } catch (Exception ex) {
//	        System.err.println("Error processing leave request: " + ex.getMessage());
//	        ex.printStackTrace();
//	        // Handle the error gracefully or rethrow if necessary
//	    }
//	}
//
//	public void receiveUserDetails(String guid) {
//	    try {
//	        System.out.println("Admin Service received User Details Request from RabbitMQ: " + guid);
//
//	        EmployeeLeaves empleaveDetails = getEmployeeDetailsWithLeaveInfo(guid);
//
//	        // Assuming rabbitTemplate is properly configured and autowired
//	        rabbitTemplate.convertAndSend("exchangeName", "user.details.routingKey", empleaveDetails);
//	    } catch (Exception e) {
//	        System.err.println("Error processing user details request: " + e.getMessage());
//	        e.printStackTrace();
//	        // Handle the error gracefully or rethrow if necessary
//	    }
//	}
//
//	private void sendLeaveInfoStatus(EmployeeLeaveDto employeeLeaveDto) {
//	    try {
//	        Optional<EmployeeLeaves> employeeDetails = empleaveleaverepo.findByGuid(employeeLeaveDto.getGuid());
//
//	        if (employeeDetails.isPresent()) {
//	            EmployeeLeaves employeeLeave = employeeDetails.get();
//	            employeeLeave.setNo_of_days_approved(employeeLeaveDto.getNo_of_days_approved());
//	            employeeLeave.setLeaveStatus(employeeLeaveDto.getLeaveStatus());
//	            empleaveleaverepo.save(employeeLeave); // Save the updated entity
//	        }
//	    } catch (Exception e) {
//	        System.err.println("Error updating leave info status: " + e.getMessage());
//	        e.printStackTrace();
//	        // Handle the error gracefully or rethrow if necessary
//	    }
//	}
       }
	

