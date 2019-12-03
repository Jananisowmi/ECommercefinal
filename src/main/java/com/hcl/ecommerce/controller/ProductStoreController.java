package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;
import com.hcl.ecommerce.service.ProductStoreService;

@RestController
@RequestMapping("/productstores")
/**
 * This is ProductStoreController class that has 1 method
 * 
 * @author Janani
 * @since 2019-11-25
 * 
 *
 */
public class ProductStoreController {

	@Autowired
	ProductStoreService productStoreService;

	/**
	 * 
	 * @param productName
	 * @return
	 */

	@GetMapping("/productstore/product")
	public ResponseEntity<List<ProductStoreResponseDto>> productDetails(@RequestParam String productName) {
		List<ProductStoreResponseDto> productDetail = productStoreService.productDetails(productName);
		if (productDetail.isEmpty()) {
			return new ResponseEntity<>(productDetail, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(productDetail, HttpStatus.OK);
	}
}
