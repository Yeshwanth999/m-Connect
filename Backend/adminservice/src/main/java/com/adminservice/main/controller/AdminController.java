package com.adminservice.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.main.dto.EmployeeLeaveDto;
import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.entity.EmployeeLeaves;
import com.adminservice.main.helperclasses.ResponseMsg;
import com.adminservice.main.service.AdminService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://127.0.0.1:5504", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/register")
	public ResponseEntity<ResponseMsg> registerUserAccount(@RequestBody RegistrationdDTO registrationDTO) {
		ResponseMsg body = adminService.empregister(registrationDTO);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}

	// }
	// @PutMapping("/LeaveRequests/{admingmail}")
	// public String leaveRequest(@PathVariable("admingmail") String admingmail,
	// @RequestBody EmployeeLeaveDto employeeleaves) {
	// log.info("Employee leaves Requests method running.");
	// String body = adminService.leaveRequestService(admingmail, employeeleaves);
	// return body;
	// }
	//

	@GetMapping("/getemployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> emp = adminService.getAllEmployees();

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@GetMapping("/getemployee/{gmail}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("gmail") String gmail) {

		Employee emp = adminService.getEmployeeByGmail(gmail);

		if (emp != null) {
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(emp, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getempdata/{admingmail}/{leaveStatus}")
	public ResponseEntity<List<EmployeeLeaves>> getLeaveEmployeeDetails(@PathVariable("admingmail") String admingmail,
			@PathVariable("leaveStatus") String leaveStatus, @RequestBody EmployeeLeaveDto empleavedto) {
		log.info("Getting Leave Employees Data in control for leaveStatus: {}", leaveStatus);
		List<EmployeeLeaves> result = adminService.getLeaveEmployeeDetailsService(admingmail, leaveStatus);

		adminService.updateLeaveStatus(result, empleavedto);
	}

	@Transactional
	@DeleteMapping("/DropBy/{gmail}")
	public String DropUserById(@PathVariable("gmail") String gmail) {
		String data = adminService.DeleteUserById(gmail);

		// return new ResponseEntity<>(result, HttpStatus.OK);
		return ResponseEntity.ok(result);
	}

}

// @PostMapping("/adduser")
// public ResponseEntity<String> addUser(@RequestBody RegistrationDto user) {
// userService.addUser(user);
//
// return ResponseEntity.ok("Employee added Succesfully");
// }
