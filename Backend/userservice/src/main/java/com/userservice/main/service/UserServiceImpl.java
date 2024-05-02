package com.userservice.main.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.commons.io.FilenameUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.userservice.main.entity.EmpAttandence;
import com.userservice.main.entity.Employee;
import com.userservice.main.entity.EmployeeLeave;
import com.userservice.main.entity.UserEntity;
import com.userservice.main.exception.ErrorMessage;
import com.userservice.main.registration.dto.EmailUtils;
import com.userservice.main.registration.dto.EmpAttandenceDto;
import com.userservice.main.registration.dto.EmployeeLeaveDto;
import com.userservice.main.registration.dto.LoginForm;
import com.userservice.main.registration.dto.PasswordUtils;
import com.userservice.main.registration.dto.RegistrationDto;
import com.userservice.main.registration.dto.ResponseMsg;
import com.userservice.main.repository.EmpAttandenceRepo;
import com.userservice.main.repository.EmployeeLeaveRepository;
import com.userservice.main.repository.EmployeeRepo;
import com.userservice.main.repository.UserRepository;
//import jakarta.persistence.NonUniqueResultException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private EmployeeRepo emprepo;

	@Autowired
	private EmployeeLeaveRepository empleaverepo;

	@Autowired
	private EmailUtils emailutils;

	@Autowired
	private RabbitTemplate rabbitTemplate;

//	@Autowired
//	private MessageConverter messageConverter;
//	
	@Autowired
	private EmpAttandenceRepo empAttandencerepo;

	@Override
	public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
		UserEntity user = userrepo.findByGmail(gmail);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with gmail: " + gmail);
		}
		return new org.springframework.security.core.userdetails.User(user.getGmail(), user.getPassword(),
				Collections.emptyList());
	}
	
	
	@Override
	public String userLogin(LoginForm loginform) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		UserEntity user = userrepo.findByGmail(loginform.getGmail());

		log.info("Employee Loging... method running. ");

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
	public Employee getEmployeeById(String gmail) {

		Optional<Employee> emp = emprepo.findByGmail(gmail);

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

			log.info("Employee Forgot Password Message Sending To Mail ... Method Running.");
			emailutils.sendmail(to, subject, body.toString());
//			return true;
			return temppwd;

		} catch (Exception e) {
			// Handle the exception appropriately (log, throw, etc.) using exception class.
			throw new ErrorMessage(e);
		}
	}

	
	@Override
	public boolean getOtp(String gmail, String otp) {

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
					log.info("Employee getotp ... Method Running.");
					if (encodedpwd.equals(pwd) && !"".equals(encodedpwd)) {
						user.setAccStatus("UNLOKED");
						userrepo.save(user);
						return true;
					}
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		} catch (Exception e) {
			// Handle the exception appropriately (log, throw, etc.) using exception class.
			throw new ErrorMessage(e);
		}
		return false;
	}

	@Override
	public String setpassword(String gmail, String password) {

		UserEntity user = userrepo.findByGmail(gmail);
		log.info("Employee Re-Setting Password... Method Running.");

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
	public ResponseMsg updateEmp(String gmail, RegistrationDto registerEmp) {

		Optional<Employee> empOptional = emprepo.findByGmail(gmail);
		System.out.println("method checking:--------->" + empOptional != null);
		
		if (empOptional.isPresent()) {
			log.info("Updating Employee Details... Method Running.");
			
			Employee emp = empOptional.get();

			EmployeeLeave updatedata = new EmployeeLeave();

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

			BeanUtils.copyProperties(emp, updatedata);
			empleaverepo.save(updatedata);

			EmpAttandence uploadEmpId = new EmpAttandence();
			BeanUtils.copyProperties(emp, uploadEmpId);
			empAttandencerepo.save(uploadEmpId);

			return new ResponseMsg(true, emp.getFirstname(), "Employee updated successfully.");

		} else {
			return new ResponseMsg(false, "", "Employee with" + gmail + "ID not found.");
		}
	}

	@Override
	public EmployeeLeave applyLeave(EmployeeLeave employeeLeave) {
		return empleaverepo.save(employeeLeave);
	}

//	@Override
//	public String deleteemp(String guid) {	     
//		return emprepo.delete(guid);
//	}
//	
	@Override
	public String DeleteUserById(String gmail) {
		emprepo.deleteByGmail(gmail);
//		userrepo.deleteAll();
		return "User Data Droped";
	}

//	@Override
//	public void createEmployeeLeave(Employee employee) {
//        // Create EmployeeLeave entity based on the provided Employee data
//        EmployeeLeave employeeLeave = new EmployeeLeave();
//        employeeLeave.setEmployeeId(employee.getId());
//        // Set other fields as needed
//        
//        // Save EmployeeLeave entity to the database
//        employeeLeaveRepository.save(employeeLeave);
//    }

	@Override
	public ResponseMsg saveLeaveDetails(String gmail, EmployeeLeaveDto empDto) {
		Optional<EmployeeLeave> employeeLeaveDataOptional = empleaverepo.findByGmail(gmail);

		log.info("Employee Leave Details Form Filling  ....Method Running.");

		if (employeeLeaveDataOptional.isPresent()) {
			EmployeeLeave employeeLeave = employeeLeaveDataOptional.get();

			// Update the fields of the existing entity
			employeeLeave.setAdmingmail(empDto.getAdmingmail());
			employeeLeave.setGmail(empDto.getGmail());
			employeeLeave.setType(empDto.getType());
			employeeLeave.setFromDate(empDto.getFromDate());
			employeeLeave.setFromShift(empDto.getFromShift());
			employeeLeave.setToDate(empDto.getToDate());
			employeeLeave.setToShift(empDto.getToShift());
			employeeLeave.setReasonFor(empDto.getReasonFor());
			employeeLeave.setAdmingmail(empDto.getAdmingmail());

			// Save the updated entity
			employeeLeave = empleaverepo.save(employeeLeave);

//			messagesend(guid);

			rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, employeeLeave.toString());

			// Send approval notification to admin service

			log.info("Employee Leave Details Data Sending to Perticular Admin... " + "Method Running. Data is :"
					+ employeeLeave.toString());

			return new ResponseMsg(true, employeeLeave.getGmail(), "Leave request updated successfully");
		} else {
			return new ResponseMsg(false, " ", "Employee leave data not found for the provided GUID: " + gmail);
		}
	}

//	private String messagesend(String guid) {
//		
//		
//			EmployeeLeave employeeLeave= new EmployeeLeave();
//			
//			0,employeeLeave.getAdmingmail(),0,0,0,0,0,null,employeeLeave.getType(),employeeLeave.getFromDate(),employeeLeave.getFromShift(),employeeLeave.getToDate()
//					,employeeLeave.getToShift(),employeeLeave.getReasonFor()); 
//			
// 	Ensure that employeeLeave is converted to JSON before sending

//		Message message = MessageBuilder
//				         .withBody(convertObjectToJsonBytes(employeeLeave.toString())).andProperties(
//				MessagePropertiesBuilder.newInstance().setContentType(MessageProperties.CONTENT_TYPE_JSON).build())
//				.build();

//			System.out.println("Leave Request is sent Successfully.");
//		
//	  return "Leave Request is sent Successfully.";
//	
//	}

//	private byte[] convertObjectToJsonBytes(Object object) throws MessageConversionException {
//		try {
//			return messageConverter.toMessage(object, null).getBody();
//		} catch (MessageConversionException e) {
//			throw new RuntimeException("Failed to convert object to JSON bytes", e);
//		}
//	}
	
	@Override
	public ResponseMsg saveattendence(String gmail, EmpAttandenceDto empattandenceDto) {

		Optional<EmpAttandence> attandencedata = empAttandencerepo.findByGmail(gmail);

		if (attandencedata.isPresent()) {
			EmpAttandence empAttandence = attandencedata.get();
			empAttandence.setDate(empattandenceDto.getDate());
			empAttandence.setClockInTime(empattandenceDto.getClockInTime());
			empAttandence.setClockOutTime(empattandenceDto.getClockOutTime());
			empAttandence.setBreakHours(empattandenceDto.getBreakHours());
			empAttandence.setAnomalous(empattandenceDto.getAnomalous());
			empAttandence.setTotalHours(empattandenceDto.getTotalHours());
			empAttandence.setFirstBreakStart(empattandenceDto.getFirstBreakStart());
			empAttandence.setFirstBreakEnd(empattandenceDto.getFirstBreakEnd());
			empAttandence.setSecondBreakStart(empattandenceDto.getSecondBreakStart());
			empAttandence.setSecondBreakEnd(empattandenceDto.getSecondBreakEnd());
			empAttandence.setThirdBreakStart(empattandenceDto.getThirdBreakStart());
			empAttandence.setThirdBreakEnd(empattandenceDto.getThirdBreakEnd());
			
			empAttandencerepo.save(empAttandence);

			return new ResponseMsg(true, empAttandence.getGuid(), "Employee Atteandence Stored Succesfully.");
		} else {
			return new ResponseMsg(false, " ", "Error Occured Employee Atteandence Not Stored.");
		}

	}

	private static final String Upload_pathfile = "static/files";

	@Override
	public String addImage(String gmail, MultipartFile file) {
	    try {
	        if (file.isEmpty()) {
	            return "File is Empty";
	        }
	        
	        Optional<Employee> optionalClass = emprepo.findByGmail(gmail);
	        if (optionalClass.isPresent()) {
	            Employee empdata = optionalClass.get();
	            
	            String fileName = empdata.getGuid() + "_" + file.getOriginalFilename();
	            empdata.setImgName(fileName);

	            String fileType = getFileType(file.getOriginalFilename());
	            empdata.setImgType(fileType);
	            
	            Path uploadPath = Paths.get("src/main/resources/" + Upload_pathfile).toAbsolutePath().normalize();
	            System.out.println("Upload Path: " + uploadPath);
	            
	            File directory = new File(uploadPath.toString());
	            if (!directory.exists()) {
	                if (directory.mkdirs()) { // Use mkdirs() to create parent directories if they don't exist
	                    System.out.println("Directory Created Successfully.");
	                } else {
	                    System.out.println("Failed to create Directory.");
	                    return "Failed to create directory for file upload.";
	                }
	            }

	            Path filePath = uploadPath.resolve(fileName).normalize();
	            System.out.println("File Path: " + filePath);
	            
	            file.transferTo(filePath.toFile());
	            System.out.println("File uploaded successfully. Path: " + filePath);

	            // Set the full file path in imgPath
	            empdata.setImgPath(filePath.toString());

	            // Save the changes to the UserDtls object
	            emprepo.save(empdata);

	            return "File uploaded successfully";
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "Failed to upload file: " + e.getMessage();
	    }
	    
	    // Return an appropriate message if the user is not present
	    return "User not found";
	}

	private String getFileType(String filename) {
		int dotIndex = filename.lastIndexOf('.');
		if (dotIndex > 0 && dotIndex < filename.length() - 1) {
			return filename.substring(dotIndex + 1).toLowerCase();
		}
		return null;
	} 
	
	@Override
	public ResponseEntity<Resource> getProfileImage(String gmail){
		
		try {
	        Optional<Employee> optionalUser = emprepo.findByGmail(gmail);
	        
	         if (optionalUser.isPresent()) {
		            Employee user = optionalUser.get();
		            // Validate or sanitize the file name to prevent directory traversal attacks
		            String fileName = user.getImgName();
		            String sanitizedFileName = FilenameUtils.getName(fileName);
		            Path filePath = Paths.get("src/main/resources/static/files").resolve(sanitizedFileName).normalize();
		            
		        // Use FileSystemResource instead of UrlResource
		            Resource resource = new FileSystemResource(filePath.toFile());

	            // Log the file path for debugging

	            // Check if the file exists and is readable
		            
	            if (resource.exists() && resource.isReadable()) {
	                // Dynamically determine content type based on file extension
	                String contentType = Files.probeContentType(filePath);
	                
	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.parseMediaType(contentType));
	                return ResponseEntity.ok().headers(headers).body(resource);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } else {
	            return ResponseEntity.notFound().build(); // Return 404 if the user is not found
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // Log the error

	        // Provide a more informative response for internal server errors
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(null); // You may consider returning a specific Resource instance here
	    
	    }
	}


	@Override
	public String deleteRecord(String guid) {
	    empAttandencerepo.deleteByGuid(guid);
	    return "Deleted Successfully.";
	}


	

}
