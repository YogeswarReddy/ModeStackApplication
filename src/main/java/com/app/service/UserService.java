package com.app.service;

import com.app.entity.User;
import com.app.exceptions.RequiredFiledsException;
import com.app.exceptions.UserNotFoundException;
import com.app.exceptions.UserServiceException;


public interface UserService {
	
	public String registerUserDtls( User user) throws UserNotFoundException, UserServiceException,RequiredFiledsException;
	
	public String userLogIn(String username,String password);

}
