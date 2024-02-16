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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import javax.persistence.NonUniqueResultException;
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
	@Transactional
	public String addUser(RegistrationDto user) {
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPwd);

		UserEntity usr = new UserEntity();
		usr.setGmail(user.getGmail());
		usr.setGuid(generateID());
//		System.out.println("===================="+generateID()+"+++++++++++++++++++");
		usr.setAdminStatus(user.getAdminStatus());
		
		usr.setPassword(encryptedPwd);

		UserEntity saveUser = userrepo.save(usr);

//		System.out.println("----------------" + saveUser.getPassword() + "----------------");

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

	
	
	
	
}
