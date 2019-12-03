package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")

/**
 * This is UserController class that has 1 method
 * 
 * @author Janani
 * @since 2019-11-25
 * 
 *
 */
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 
	 * @param userRequestDto
	 * @return
	 */

	@PostMapping("")
	public ResponseEntity<String> loginUser(@RequestBody UserRequestDto userRequestDto) {
		String user = userService.loginUser(userRequestDto);
		if (user.equals(ECommerceConstants.LOGIN_SUCCESS_MESSAGE)) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}

	}
}
