package com.adminservice.main.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.adminservice.main.repository.EmpAttandenceRepo;
import com.adminservice.main.repository.EmployeeLeaveRepository;
import com.adminservice.main.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Component
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepo; // Employee data

	@Autowired
	private UserRepo emprepo; // Employee login data

	@Autowired
	private EmployeeLeaveRepository empleaveleaverepo;

	@Autowired
	private EmpAttandenceRepo empattendencerepo;

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

		log.info("Empployee Registering");

		Optional<Employee> profileRegister = adminrepo.findByGmail(registerEmp.getGmail());

		if (profileRegister.isPresent()) {
			return new ResponseMsg(false, registerEmp.getGmail(), "This Email We have in our DataBase.");
		} else {
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
		emprepo.deleteByGmail(gmail);
		empleaveleaverepo.deleteByGmail(gmail);
		empattendencerepo.deleteByGmail(gmail);
		return "Successfully Data Droped";
	}

	public EmployeeLeaves getEmployeeDetailsWithLeaveInfo(String gmail) {
		return empleaveleaverepo.findByGmail(gmail).orElse(null);
	}

//	@Override
//	public String leaveRequestService(String admingmail, EmployeeLeaveDto employeeleaves) {
//		Optional<EmployeeLeaves> employeeLeaveDataOptional = empleaveleaverepo.findAllByAdmingmail(admingmail);
//		System.out.println("Employee Leaves Cheacking--------->");
//
//		if (employeeLeaveDataOptional.isPresent()) {
//			log.info("Updating Employee Leaves Details... Method Running.");
//
//			EmployeeLeaves employeeLeave = employeeLeaveDataOptional.get();
//
//			employeeLeave.setFromDate(employeeleaves.getFromDate());
//			employeeLeave.setFromShift(employeeleaves.getFromShift());
//			employeeLeave.setLeaveStatus(employeeleaves.getLeaveStatus());
//			employeeLeave.setToDate(employeeleaves.getToDate());
//			employeeLeave.setToShift(employeeleaves.getToShift());
//
//			empleaveleaverepo.save(employeeLeave);
//
//			log.info("Leave Status Updated in Service impl class");
//
//			return "Leave request updated successfully";
//		} else {
//			return ("Employee leave data not found for the provided Employee AdminGmail: " + admingmail);
//		}
//	}

//	}
//	@Override
//	public List<EmployeeLeaves> getLeaveEmployeeDetailsService(String admingmail) {
//	    List<EmployeeLeaves> empLeavesList = empleaveleaverepo.findAllByAdmingmail(admingmail);
//	    
//	    List<EmployeeLeaves> validLeaves = new ArrayList<>();
//
//	    for (EmployeeLeaves empdata : empLeavesList) {
//	        String leaveStatus = empdata.getLeaveStatus();
//	        System.out.println(leaveStatus);
//	        if ("LeaveRequest".equals(leaveStatus)) {
//	            validLeaves.add(empdata);
//	        }
//	    }
//
//	    return validLeaves;

	@Override
	public List<EmployeeLeaves> getLeaveEmployeeDetailsService(String admingmail, String leaveStatus) {
		List<EmployeeLeaves> allEmployees = empleaveleaverepo.findAllByAdmingmail(admingmail);

		List<EmployeeLeaves> filteredEmployees = allEmployees.stream()
				.filter(employee -> leaveStatus.equals(employee.getLeaveStatus())).collect(Collectors.toList());

		return filteredEmployees;
	}

	@Override
	public String updateLeaveStatus(List<EmployeeLeaves> employees, EmployeeLeaveDto employeeleaves) {
		for (EmployeeLeaves employee : employees) {
			employee.setLeaveStatus(employeeleaves.getLeaveStatus());
			employee.setFromDate(employeeleaves.getFromDate());
			employee.setToDate(employeeleaves.getToDate());
			employee.setNo_of_days_approved(employeeleaves.getNo_of_days_approved());
			empleaveleaverepo.save(employee);
		
		}
		
		return "Leave Status Updated Successfully";
	}

}
