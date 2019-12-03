package com.hcl.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Test
	public void testsaveProductPositive() {
		Product product = new Product();
		when(productRepository.save(product)).thenReturn(product);
		
		String response = productServiceImpl.saveProduct("pen");
		assertEquals("Product is added", response);
	}

	@Test
	public void testsaveProductNegative() {
		String message = "Product is not added";
		String expectedString = productServiceImpl.saveProduct(message);
		assertNotEquals(expectedString, message);

	}

	@Test
	public void testfindProductByProductNamePositive() {
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Pen");
		products.add(product);
		
		when(productRepository.findAll()).thenReturn(products);
		
		List<Product> result = productServiceImpl.findProductByProductName("pen");
		assertThat(result).hasSize(1);
	
	}

	@Test
	public void testfindProductByProductNameNegative() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setProductId(2);
		product.setProductName("Pencil");
		productList.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<Product> productLists = productServiceImpl.findProductByProductName("pen");
		assertEquals(productLists.size(), productList.size());
	}
}
