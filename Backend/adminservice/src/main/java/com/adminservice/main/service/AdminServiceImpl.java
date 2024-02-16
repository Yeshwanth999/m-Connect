package com.adminservice.main.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.entity.Employee;
import com.adminservice.main.entity.User;
import com.adminservice.main.helperclasses.ResponseMsg;
import com.adminservice.main.repository.AdminRepository;
import com.adminservice.main.repository.UserRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminrepo;

	@Autowired
	private UserRepo emprepo;

	public AdminServiceImpl(AdminRepository adminrepo) {
		this.adminrepo = adminrepo;
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
	    public ResponseMsg empregister(RegistrationdDTO registerEmp) {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encrypetedPwd = bcrypt.encode(registerEmp.getPassword());
		registerEmp.setPassword(encrypetedPwd);

		Employee emp = new Employee();
		emp.setGuid(registerEmp.getGuid());
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
	public String DeleteUserById(long id) {
       	adminrepo.deleteById(id);
//		userrepo.deleteAll();
		return "User Data Droped";
	}
	
	
	
	

}
