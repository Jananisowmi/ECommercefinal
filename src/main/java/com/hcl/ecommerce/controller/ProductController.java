
package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")

/**
 * This is ProductController class that has 2 methods
 * 
 * @author Janani
 * @since 2019-11-25
 * 
 *
 */
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * 
	 * @param productName
	 * @return
	 */
	@PostMapping("/{productName}")
	public ResponseEntity<String> saveProduct(@RequestParam(name = "productName") String productName) {
		String result = productService.saveProduct(productName);
		if (result.equals(ECommerceConstants.PRODUCT_SUCCESS_MESSAGE)) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

	}

	/**
	 * 
	 * @param productName
	 * @return
	 */

	@GetMapping("/{productName}")
	public ResponseEntity<List<Product>> getProductName(@RequestParam String productName) {
		List<Product> product = productService.findProductByProductName(productName);
		if (product.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

}
