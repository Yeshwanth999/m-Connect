package com.userservice.main.service;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userservice.main.entity.Employee;
import com.userservice.main.entity.UserEntity;
import com.userservice.main.registration.dto.EmailUtils;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.PasswordUtils;
import com.userservice.main.registration.dto.RegistrationDto;
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

		if (user != null) {

			String Password1 = loginform.getPassword();

			String hashedPassword = user.getPassword();

			// Compare the provided password with the stored hashed password
			if (bcrypt.matches(Password1, hashedPassword)) {
				
				return "success";
				
			} else {
				return "Incorrect password";
			}
		} else {
			return "User not found";
		}
	}

	@Override
	@Transactional
	public String addUser(RegistrationDto user) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		System.out.println("----------------" + user.getPassword() + "----------------");

		String encryptedPwd = bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPwd);

		UserEntity usr = new UserEntity();
		usr.setGmail(user.getGmail());
		usr.setGuid(user.getGuid());
		usr.setRole(user.getRole());
		usr.setPassword(encryptedPwd);

		UserEntity saveUser = userrepo.save(usr);

		System.out.println("----------------" + saveUser.getPassword() + "----------------");

		return saveUser.getGmail() + "Employee added successfully...";

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

		String temppwd = PasswordUtils.generateRandomPwd();
		MessageDigest digest;

		try {
			digest = MessageDigest.getInstance("SHA-256");
			digest.reset();
			digest.update(temppwd.getBytes());
			byte[] encryptedPwd = digest.digest();
			String encodepwd = Base64.getEncoder().encodeToString(encryptedPwd);

			UserEntity user = new UserEntity();
			user.setGmail(loginform.getGmail());
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
	public boolean getOtp(String gmail, String otp) {
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
	public String DeleteUserById(long id) {
		userrepo.deleteById(id);
		return "User Data Droped";
	}
	
	
	
}
