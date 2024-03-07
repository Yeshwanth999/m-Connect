package com.adminservice.main.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeLeaveDto implements Serializable{

	private String type;
	private String guid;
	private int no_of_days_approved;
	private String admingmail;
	private LocalDate fromDate;
	private String fromShift;
	private LocalDate toDate;
	private String toShift;
	private String reasonFor;
	private int annual_leave_balance;
	private int annual_leaves_used;
	private int monthly_leave_balance;
	private int monthly_leaves_used;
	private String leaveStatus;
	
	
	
}
