package com.userservice.main.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LeaveStatus {
	
	public EmployeeLeaveDto empleaveDto;
	public String status;
	public String Message;

}
