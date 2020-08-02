package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.ErrorCodes;
import com.app.common.UserConstants;
import com.app.entity.User;
import com.app.exceptions.RequiredFiledsException;
import com.app.repository.UserRepository;
import com.app.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String registerUserDtls(User user) throws RequiredFiledsException {
		
		if (user.getUsername() == null) {
			
			throw new RequiredFiledsException(ErrorCodes.MANDATORY_FIELDS_MISSING);
		} 
         else {
        	 User registeredUser = userRepository.save(user);
     		
     		return registeredUser.getUserId() != null ? UserConstants.USER_CREATED : UserConstants.USER_NOT_CREATED;
		}
		
	}

	@Override
	public String userLogIn(String username, String password) {
		boolean check = userRepository.existsByUsernameAndPassword(username, password);
		return check ? UserConstants.USER_LOGIN_SUCCESS : UserConstants.USER_LOGIN_FAILED;
	}

	public boolean checkUserExists(String username) {

		return userRepository.existsByUsername(username);
	}
}
