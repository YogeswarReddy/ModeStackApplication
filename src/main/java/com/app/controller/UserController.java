package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.UserConstants;
import com.app.entity.User;
import com.app.entity.UserLogIn;
import com.app.exceptions.RequiredFiledsException;
import com.app.service.impl.UserServiceImpl;
import com.app.util.UserUtil;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserUtil userUtil;

	Map<String, String> responseMessage = new HashMap<>();
	Map<String, Object> responseStatusCode = new HashMap<>();
	Map<String, Map<String, Object>> response = new HashMap<>();

	@PostMapping("/register")
	public ResponseEntity<Map<String, Map<String, Object>>> registerUserD(@RequestBody User user)
			throws RequiredFiledsException {


		if (!userServiceImpl.checkUserExists(user.getUsername())) {
			String msg = userServiceImpl.registerUserDtls(user);

			responseMessage.put("Message", msg);
			responseStatusCode.put(UserConstants.STATUS_CODE, UserConstants.USER_REGISTER_STATUS_CODE);
			responseStatusCode.put(UserConstants.BODY, responseMessage);
			response.put(UserConstants.RESPONSE, responseStatusCode);

			return new ResponseEntity<Map<String, Map<String, Object>>>(response, HttpStatus.CREATED);
		}
		else {
			responseStatusCode.put(UserConstants.STATUS_CODE, UserConstants.DUPLICATE_USER_CODE);
			responseStatusCode.put(UserConstants.BODY, UserConstants.USER_EXISTED);
			response.put(UserConstants.RESPONSE,responseStatusCode);
			
			return new ResponseEntity<Map<String, Map<String, Object>>>(response,HttpStatus.BAD_REQUEST);
		}
		


	//return new ResponseEntity<Map<String, Map<String, Object>>>(response, HttpStatus.CONFLICT);
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Map<String, Object>>> userLogIn(@RequestBody UserLogIn userLogIn) {

		String msg = userServiceImpl.userLogIn(userLogIn.getUsername(), userLogIn.getPassword());
		
		//return check ? UserConstants.USER_LOGIN_SUCCESS : UserConstants.USER_LOGIN_FAILED;
		if(msg.equals(UserConstants.USER_LOGIN_SUCCESS)) {
						
		responseMessage.put("Message", msg);
		responseMessage.put(UserConstants.ACCESS_TOKEN, userUtil.getToken());
		responseStatusCode.put(UserConstants.STATUS_CODE,UserConstants.USER_LOGIN_STATUS_CODE);
		responseStatusCode.put(UserConstants.BODY, responseMessage);
		
		
		response.put(UserConstants.RESPONSE, responseStatusCode);
		
           
		return new ResponseEntity<Map<String, Map<String, Object>>>(response, HttpStatus.OK);
		}
		else {
			responseStatusCode.put(UserConstants.STATUS_CODE, UserConstants.INVAID_USER_CODE);
			responseStatusCode.put(UserConstants.BODY, UserConstants.USER_LOGIN_FAILED);
			response.put(UserConstants.RESPONSE,responseStatusCode);
			
			return new ResponseEntity<Map<String, Map<String, Object>>>(response,HttpStatus.BAD_REQUEST);
		}
	}

}
