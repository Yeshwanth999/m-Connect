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
    private LocalDate fromDate;
    private String fromShift;
    private LocalDate toDate;
    private String toShift;
    private String reasonFor;
   
  }


