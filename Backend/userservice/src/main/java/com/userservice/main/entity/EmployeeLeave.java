package com.userservice.main.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.userservice.main.registration.dto.EmployeeLeaveDto;
import com.userservice.main.registration.dto.ResponseMsg;

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
    private Long id;
	private String giud;
    private String type;
    private LocalDate fromDate;
    private String fromShift;
    private LocalDate toDate;
    private String toShift;
    private String reasonFor;
	
 
 }