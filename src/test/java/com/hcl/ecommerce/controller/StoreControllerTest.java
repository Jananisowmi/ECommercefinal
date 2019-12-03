package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTest {

	@InjectMocks
	StoreController stockController;

	@Mock
	StoreService storeService;

	@Test
	public void testsaveStorePositive() {
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		storeRequestDto.setStoreName("D-Mart");
		storeRequestDto.setContactNumber("9865526711");
		storeRequestDto.setStoreLocation("E city");
		String message = "Store is added";
		Mockito.when(storeService.saveStore(storeRequestDto)).thenReturn(message);
		Integer result = stockController.saveStore(storeRequestDto).getStatusCodeValue();
		assertEquals(200, result);

	}

	@Test
	public void testsaveStoreNegative() {
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		storeRequestDto.setStoreName("D-Mart");
		storeRequestDto.setContactNumber("9865526711");
		storeRequestDto.setStoreLocation("E city");
		String message = "Store is not added";
		Mockito.when(storeService.saveStore(storeRequestDto)).thenReturn(message);
		Integer result = stockController.saveStore(storeRequestDto).getStatusCodeValue();
		assertEquals(204, result);
	}
}
