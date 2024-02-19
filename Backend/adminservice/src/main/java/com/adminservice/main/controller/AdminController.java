package com.adminservice.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.helperclasses.ResponseMsg;
import com.adminservice.main.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/register")
	public ResponseEntity<ResponseMsg> registerUserAccount(@RequestBody RegistrationdDTO registrationDTO) {
		ResponseMsg body = adminService.empregister(registrationDTO);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	@DeleteMapping("DropBy/{id}")
	public String DropUserById(@PathVariable("id") long id) {

		String data = adminService.DeleteUserById(id);

		return data;
	}

//	@PostMapping("/adduser")
//	public ResponseEntity<String> addUser(@RequestBody RegistrationDto user) {
//		userService.addUser(user);
//
//		return ResponseEntity.ok("Employee added Succesfully");
//	}
//
//	@GetMapping("/getemployees")
//	public ResponseEntity<List<Employee>> getAllEmployees() {
//
//		List<Employee> emp = userService.getAllEmployees();
//
//		return new ResponseEntity<>(emp, HttpStatus.OK);
//	}
//	
//	@GetMapping("/getemployee/{id}")
//	public ResponseEntity<Employee> getEmpById(@PathVariable Long id) {
//
//		Employee emp = userService.getEmployeeById(id);
//
//		if (emp != null) {
//			return new ResponseEntity<>(emp, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
//		}
//
//	}
//
//	@DeleteMapping("DropBy/{id}")
//	public String DropUserById(@PathVariable("id") long id) {
//		
//		String data = userService.DeleteUserById(id);
//		return data;
//	}

}
