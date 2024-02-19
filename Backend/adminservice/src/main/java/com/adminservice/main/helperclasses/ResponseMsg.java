package com.adminservice.main.helperclasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMsg {
	
	private Boolean status;
	private Object msg;
	private String guid;

	
	
	
}
