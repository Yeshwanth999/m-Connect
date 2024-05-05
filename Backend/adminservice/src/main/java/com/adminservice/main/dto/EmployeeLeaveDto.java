package com.adminservice.main.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuppressWarnings("serial")
public class EmployeeLeaveDto implements Serializable {
	
	private String type;
	private String gmail;
	private int no_of_days_approved;
	private String admingmail;	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	private String fromShift;
    @JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;
	private String toShift;
	private String reasonFor;
	private int annual_leave_balance;
	private int annual_leaves_used;
	private int monthly_leave_balance;
	private int no_of_days_applied;
	private int monthly_leaves_used;
	private String leaveType;
	private String leaveStatus;
    private int adminChecked;

	
   }
