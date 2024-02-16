package com.adminservice.main.service;

import com.adminservice.main.dto.RegistrationdDTO;
import com.adminservice.main.helperclasses.ResponseMsg;


public interface AdminService {

     ResponseMsg empregister(RegistrationdDTO registrationDTO);

	 String DeleteUserById(long id);
		
}
