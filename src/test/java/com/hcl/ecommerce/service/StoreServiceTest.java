package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceTest {

	@InjectMocks
	StoreServiceImpl storeServiceImpl;

	@Mock
	StoreRepository storeRepository;

	@Test
	public void testsaveStorePositive() {
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		Store store = new Store();
		store.setStoreId(1);
		store.setContactNumber("9865526711");
		store.setStoreLocation("E city");
		store.setStoreName("D-Mart");
		String message = "Store is added";
		String expected = storeServiceImpl.saveStore(storeRequestDto);
		assertEquals(expected, message);

	}

	@Test
	public void testsaveStoreNegative() {
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		String message = "Store is not added";
		String expected = storeServiceImpl.saveStore(storeRequestDto);
		assertNotEquals(expected, message);

	}

	@Test
	public void testfindStoreByStoreIdPositive() throws StoreNotFoundException {

		Store store = new Store();
		store.setContactNumber("9865526711");
		store.setStoreId(1);
		store.setStoreLocation("E city");
		store.setStoreName("D Mart");
		Mockito.when(storeRepository.findStoreByStoreId(2)).thenReturn(store);
		Store storeExpected = storeServiceImpl.findStoreByStoreId(2);
		assertEquals(storeExpected, store);
	}

	@Test(expected = StoreNotFoundException.class)
	public void testfindStoreByStoreIdNegative() throws StoreNotFoundException {

		Store store = new Store();
		store.setContactNumber("9865526711");
		store.setStoreId(1);
		store.setStoreLocation("E city");
		store.setStoreName("D Mart");
		Mockito.when(storeRepository.findStoreByStoreId(1)).thenReturn(null);
		Store expectedStore = storeServiceImpl.findStoreByStoreId(1);
		assertEquals(expectedStore, store);
	}

}
