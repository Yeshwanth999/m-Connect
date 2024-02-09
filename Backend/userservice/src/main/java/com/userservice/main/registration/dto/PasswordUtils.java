package com.userservice.main.registration.dto;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordUtils {
	
	public static String generateRandomPwd() {
		
		String charactor ="0123456789";
		
		String pwd = RandomStringUtils.random(6,charactor);
		
		return pwd;
	}

}
