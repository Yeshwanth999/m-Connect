package com.userservice.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.userservice.main.entity.Employee;
import com.userservice.main.registration.dto.EmpResponse;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.RegistrationDto;
import com.userservice.main.service.UserService;

@CrossOrigin(origins = "http://127.0.0.1:5503" , methods = {RequestMethod.POST, RequestMethod.OPTIONS})
@RestController
@JsonInclude(Include.NON_NULL)
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public RegistrationDto regitrationDto;

//	@GetMapping
//	public String showRegistrationForm() {
//		return "registration";
//	}

//	@PostMapping("register")
//	public ResponseEntity<String> registerUserAccount(@RequestBody RegistrationDto registrationDTO) {
//		userService.save(registrationDTO);
//		return ResponseEntity.ok("User Created Succesfully.");
//	}

	@PostMapping("adduser")
	public ResponseEntity<String> addUser(@RequestBody RegistrationDto user){
		userService.addUser(user);
		
		return ResponseEntity.ok("Employee added Succesfully");
	   }

	
	@PostMapping("/login")
	public String userlogin(@RequestBody LoginForm loginform) {
		return userService.userLogin(loginform);
//		return ResponseEntity.ok(result);
         
	  }
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<EmpResponse> forgotPassword(@RequestBody LoginForm loginform ){
	    
		EmpResponse msg1 = new EmpResponse();
	
		String msg = userService.forgotPassword(loginform);
//		msg1.setData(loginform);
	    msg1.setMessage(msg);
		return new ResponseEntity<>( msg1, HttpStatus.OK);
	}
	
	@PostMapping("/verifyOtp")
	public ResponseEntity<String> VerifyOtp(@RequestParam("gmail") String gmail,@RequestParam("otp")String otp){
		
		
		Boolean flag = userService.getOtp(gmail,otp);
		
		if(flag) {
			return ResponseEntity.ok("OTP Verification is Succesfull..");
		}else {
			return ResponseEntity.badRequest().body("Invalid OTP.");
		}	
	}
	
	@PostMapping("/setPassword")
	public ResponseEntity<String> setPassword(@RequestParam("gmail") String gmail,@RequestParam("password") String password){
		
		 String result = userService.setpassword(gmail,password);
		
		  return ResponseEntity.ok(result);
		  
	}
	
	
    @PostMapping("/addEmployee")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee){
    	
    	Employee emp = userService.saveEmployee(employee);
    	
    	return new ResponseEntity<>(emp, HttpStatus.CREATED);
    
    }
    
    @GetMapping("/getemployee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
    	
    	List<Employee> emp = userService.getAllEmployees();
    	
    	return new ResponseEntity<>(emp,HttpStatus.OK);
    	
    }
    @GetMapping("/getemployee/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Long id){
    
    	Employee emp = userService.getEmployeeById(id);
    	
    	if(emp != null) {
    	return new ResponseEntity<>(emp,HttpStatus.OK);
    	}else {
    		return new ResponseEntity<>(emp,HttpStatus.NOT_FOUND);
    	}
    	
    }
    
    @DeleteMapping("DropBy/{id}")
    public String DropUserById(@PathVariable("id") long id){
		
    	String data = userService.DeleteUserById(id);
    	
    	return data;
    }
    
  
    
}