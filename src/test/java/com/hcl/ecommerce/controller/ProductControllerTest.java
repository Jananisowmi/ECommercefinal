package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {

	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;

	@Test
	public void testsaveProductPositive() {
		Product product = new Product();
		product.setProductName("Pen");
		String message = "Product is added";
		Mockito.when(productService.saveProduct("pen")).thenReturn(message);
		Integer result = productController.saveProduct("pen").getStatusCodeValue();
		assertEquals(200, result);

	}

	@Test
	public void testsaveProductNegative() {
		Product product = new Product();
		product.setProductName("Pen");
		String message = "Product is not added";
		Mockito.when(productService.saveProduct("pen")).thenReturn(message);
		Integer result = productController.saveProduct("pen").getStatusCodeValue();
		assertEquals(404, result);

	}

	@Test
	public void testgetProductNamePositive() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		String productName = "Pen";
		product.setProductName("Pen");
		productList.add(product);
		Mockito.when(productService.findProductByProductName(productName)).thenReturn(productList);
		Integer actual = productController.getProductName(productName).getStatusCodeValue();
		assertEquals(200, actual);
	}

	@Test
	public void testgetProductNameNegative() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		String productName = "Pencil";
		product.setProductName("Pen");
		productList.add(product);
		Mockito.when(productService.findProductByProductName("Pen")).thenReturn(productList);
		Integer actual = productController.getProductName(productName).getStatusCodeValue();
		assertEquals(404, actual);

	}
}
