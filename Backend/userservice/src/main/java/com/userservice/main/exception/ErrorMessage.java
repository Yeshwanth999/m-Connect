package com.userservice.main.exception;

public class ErrorMessage extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Exception errorName;

	public Exception getErrorName() {
		return errorName;
	}
	
	public void setErrorName(Exception errorName) {
		this.errorName = errorName;
	}

	public ErrorMessage(Exception e) {
		this.errorName=e;
	}
}