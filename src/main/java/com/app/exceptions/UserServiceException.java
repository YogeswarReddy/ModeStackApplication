package com.app.exceptions;

public class UserServiceException extends Exception {

	private static final long serialVersionUID = -9029913700873530388L;

	public UserServiceException() {
		super();
		
	}
	
	public UserServiceException(final String message) {
		super(message);
	}
	
}
