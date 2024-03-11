package com.userservice.main.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmpAttandenceDto{

	private long id;
	private String guid;
	private String gmail;
	private String  clockInTime;
	private String clockOutTime;
	private String totalHours;
	private String  date;
	private String breakHours;
	private String anomalous;
	
}
