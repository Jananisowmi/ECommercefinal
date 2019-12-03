package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.dto.UserRequestDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.repository.UserRepository;

/**
 * This is UserServiceImpl class that has 2 methods
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * This is findUserByUserNameAndPassWord method used to find the Username and
	 * password for login
	 * 
	 * @exception UserNotPresentException
	 */

	@Override
	public User findUserByUserNameAndPassWord(String userName, String passWord) throws UserNotPresentException {
		User user = userRepository.findUserByUserNameAndPassWord(userName, passWord);
		if (user == null) {
			throw new UserNotPresentException("User not Available");
		}
		return user;
	}

	/**
	 * This is loginUser method used to login the user
	 * 
	 */
	@Override
	public String loginUser(UserRequestDto userRequestDto) {
		User user = userRepository.findUserByUserNameAndPassWord(userRequestDto.getUserName(),
				userRequestDto.getPassWord());
		String result = null;
		if (user != null) {
			result = ECommerceConstants.LOGIN_SUCCESS_MESSAGE;

		} else {
			result = "Login failed";
		}

		return result;
	}
}
