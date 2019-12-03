package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.UserOrderDto;
import com.hcl.ecommerce.entity.UserOrder;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.exception.UserNotPresentException;
import com.hcl.ecommerce.exception.UserOrderListException;
import com.hcl.ecommerce.service.UserOrderService;

@RestController
@RequestMapping("/orders")

/**
 * This is UserOrderController class that has 2 methods
 * 
 * @author Janani
 * @since 2019-11-25
 * 
 *
 */
public class UserOrderController {

	@Autowired
	UserOrderService userOrderService;

	/**
	 * 
	 * @param userOrderDto
	 * @return
	 * @throws StoreNotFoundException
	 * @throws UserNotPresentException
	 */

	@PostMapping("")
	public ResponseEntity<String> productOrder(@RequestBody UserOrderDto userOrderDto)
			throws StoreNotFoundException, UserNotPresentException {
		String result = userOrderService.userOrder(userOrderDto);
		if (result.equals("Product succesfully ordered")) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);

	}

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotPresentException
	 * @throws UserOrderListException
	 */

	@GetMapping("/{userId}")
	public ResponseEntity<List<UserOrder>> getUserOrder(@RequestParam Integer userId)
			throws UserNotPresentException, UserOrderListException {
		List<UserOrder> userOrder = userOrderService.listUserOrder(userId);
		if (userOrder.isEmpty()) {
			return new ResponseEntity<>(userOrder, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userOrder, HttpStatus.OK);

	}

}
