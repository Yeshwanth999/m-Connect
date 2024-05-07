package com.userservice.main.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpAttandenceDto{


	private String guid;
	private String gmail;
	private String  clockInTime;
	private String  date;
	
	private String firstBreakStart;
	private String firstBreakEnd;
	private String secondBreakStart;
	private String secondBreakEnd;
	private String thirdBreakStart;
	
	private String thirdBreakEnd;
	private String clockOutTime;
	private String totalHours;
	private String breakHours;
	private String anomalous;
	
}
