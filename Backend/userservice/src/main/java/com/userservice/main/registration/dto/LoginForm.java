package com.userservice.main.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginForm {
	
	private String gmail;
	private String password;
	private boolean adminStatus;

	 public boolean isAdminStatus() {
	        return adminStatus;
	    }

	    public void setAdminStatus(boolean adminStatus) {
	        this.adminStatus = adminStatus;
	    }
}