package com.userservice.main.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employeeleaves")
public class  EmployeeLeave{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String guid;
	private String admingmail;
	private int annual_leave_balance;
	private int annual_leaves_used;
	private int monthly_leave_balance;
	private int monthly_leaves_used;
	private int no_of_days_approved;
	private String leaveStatus;
    private String type;
    private LocalDate fromDate;
    private String fromShift;
    private LocalDate toDate;
    private String toShift;
    private String reasonFor;
    
    
    }