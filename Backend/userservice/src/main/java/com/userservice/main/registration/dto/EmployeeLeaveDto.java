package com.userservice.main.registration.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLeaveDto {
	
    private String type;
    private String gmail;
    private String admingmail;
    private LocalDate fromDate;
    private String fromShift;
    private LocalDate toDate;
    private String toShift;
    private String reasonFor;
	private int no_of_days_approved;
	private int annual_leave_balance;
	private int annual_leaves_used;
	private int monthly_leave_balance;
	private int monthly_leaves_used;
	private int no_of_days_applied;
	private String leaveType;
	private String leaveStatus;
    private int adminChecked;

	
	
  }


