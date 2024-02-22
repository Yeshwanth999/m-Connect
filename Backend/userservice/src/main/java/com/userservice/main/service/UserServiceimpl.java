package com.userservice.main.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.main.entity.Employee;
import com.userservice.main.entity.EmployeeLeave;
import com.userservice.main.entity.UserEntity;
import com.userservice.main.registration.dto.EmailUtils;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.PasswordUtils;
import com.userservice.main.registration.dto.RegistrationDto;
import com.userservice.main.registration.dto.ResponseMsg;
import com.userservice.main.repository.EmployeeLeaveRepository;
import com.userservice.main.repository.EmployeeRepo;
import com.userservice.main.repository.UserRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class UserServiceimpl implements UserService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private EmployeeRepo emprepo;
	
	@Autowired
	private EmployeeLeaveRepository empleaverepo;


	@Autowired
	private EmailUtils emailutils;

//    @Override
//	public UserEntity save(RegistrationDto registrationDto) {
//		
//		UserEntity userEntity = new UserEntity(
//				registrationDto.getGuid(),
//				registrationDto.getId(),
//				registrationDto.getEmail(),
//				passwordEncoder.encode(registrationDto.getPassword()),
//				registrationDto.getRole()
//				);
//				
//				return userrepo.save(userEntity);
//		
//	}

	@Override
	public String userLogin(LoginForm loginform) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		UserEntity user = userrepo.findByGmail(loginform.getGmail());

		if (user != null && bcrypt.matches(loginform.getPassword(), user.getPassword())) {
			if (user.isAdminStatus() == true) {
				return "Admin";
			} else {
				return "Employee";
			}
		} else {
			return "Incorrect username or password";
		}
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return emprepo.save(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> emp = emprepo.findAll();
		return emp;
	}

	@Override
	public Employee getEmployeeById(Long id) {

		Optional<Employee> emp = emprepo.findById(id);

		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}

	}

	@Override
	public String forgotPassword(LoginForm loginform) {

		UserEntity user = userrepo.findByGmail(loginform.getGmail());
		
		String temppwd = PasswordUtils.generateRandomPwd();
		MessageDigest digest;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(temppwd.getBytes());
			byte[] encryptedPwd = digest.digest();
			String encodepwd = Base64.getEncoder().encodeToString(encryptedPwd);

    		user.setGmail(user.getGmail());
			user.setPassword(encodepwd);
			user.setAccStatus("LOKED");
			userrepo.save(user);
			
			
			String to = loginform.getGmail();
			String subject = "Verification Your Account";
			StringBuffer body = new StringBuffer();
			body.append("<h1>'Otp For Verifying Your Account.</h1>' ");
			
			body.append("<h3>" + temppwd + "</h3>");

			emailutils.sendmail(to, subject, body.toString());
//			return true;
			return temppwd;
			
		} catch (Exception er) {
			return er.toString();
			
		}
	}

	
	@Override
	public boolean getOtp(String gmail, String otp){
		
   try {
		UserEntity user = userrepo.findByGmail(gmail);

		if (user != null) {

			String pwd = user.getPassword();
			MessageDigest digest;

			try {
				digest = MessageDigest.getInstance("SHA-256");
				digest.reset();
				digest.update(otp.getBytes());

				byte[] encryptpwd = digest.digest();
				String encodedpwd = Base64.getEncoder().encodeToString(encryptpwd);

				if (encodedpwd.equals(pwd) && !"".equals(encodedpwd)) {
					user.setAccStatus("UNLOKED");
					userrepo.save(user);
					return true;
				}
			} catch (Exception er) {
				er.printStackTrace();
			}
		}
	}catch (NonUniqueResultException e) {
        // Handle multiple matching records
        e.printStackTrace();
	}
   return false;
	}
	
	
	@Override
	public String setpassword(String gmail, String password) {

		UserEntity user = userrepo.findByGmail(gmail);

		if (user != null) {
			MessageDigest digist;
			try {
				digist = MessageDigest.getInstance("SHA-256");
				digist.reset();
				digist.update(password.getBytes());

				byte[] encryptpwd = digist.digest();

				String encodedpwd = Base64.getEncoder().encodeToString(encryptpwd);

				user.setPassword(encodedpwd);
				userrepo.save(user);

				return "Password Set Succesfully";

			} catch (Exception er) {
				er.printStackTrace();
				return "check passowrd";
			}

		} else {
			return "user not found";
		}
	}

	@Override
	public ResponseMsg updateEmp(String guid, RegistrationDto registerEmp) {

		Optional<Employee> empOptional = emprepo.findByGuid(guid);
		
		System.out.println("method checking:--------->" + empOptional != null);
		if (empOptional.isPresent()){
			
	        Employee emp = empOptional.get();
			
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			String encryptedPwd = bcrypt.encode(registerEmp.getPassword());
			
			emp.setPassword(encryptedPwd);
			emp.setBlood_group(registerEmp.getBlood_group());
			emp.setCurrentPincode(registerEmp.getCurrentPincode());
			emp.setCurrentAddress(registerEmp.getCurrentAddress());
			emp.setCurrentCity(registerEmp.getCurrentCity());
			emp.setCurrentCountry(registerEmp.getCurrentCountry());
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

			emprepo.save(emp);

			return new ResponseMsg(true, emp.getFirstname(), "Employee updated successfully.");
		} else {
			return new ResponseMsg(false, "", "Employee with"+ guid +"ID not found.");
		}
	}

	@Override
	public EmployeeLeave applyLeave(EmployeeLeave employeeLeave) {
		return empleaverepo.save(employeeLeave);
	}
	
	
	
	
}
