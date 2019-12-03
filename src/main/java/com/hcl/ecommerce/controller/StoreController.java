package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.service.StoreService;

@RestController
@RequestMapping("/stores")

/**
 * This is StoreController class that has 1 method
 * 
 * @author Janani
 * @since 2019-11-25
 * 
 *
 */
public class StoreController {

	@Autowired
	StoreService storeService;
	
	/**
	 * 
	 * @param storeRequestDto
	 * @return
	 */

	@PostMapping("")
	public ResponseEntity<String> saveStore(@RequestBody StoreRequestDto storeRequestDto) {
		String result = storeService.saveStore(storeRequestDto);
		if (result.equals(ECommerceConstants.STORE_SUCCESS_MESSAGE)) {
			return new ResponseEntity<>(result, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
		}

	}
}
