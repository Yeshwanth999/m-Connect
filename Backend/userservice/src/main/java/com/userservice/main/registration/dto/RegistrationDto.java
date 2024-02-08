package com.userservice.main.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
public class RegistrationDto {
	
	private String guid;
	private String gmail;
	private String password;
	private String role;
}
