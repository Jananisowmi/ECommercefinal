package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreReviewRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreServiceTest {

	@InjectMocks
	ProductStoreServiceImpl productStoreServiceImpl;

	@Mock
	ProductStoreRepository productStoreRepository;

	@Mock
	StoreReviewRepository storeReviewRepository;

	@Test
	public void testProductDetailsPositive() {

		ProductStore productStore = new ProductStore();
		List<ProductStore> listProductStore = new ArrayList<ProductStore>();
		productStore.setId(1);
		productStore.setPrice(100);
		productStore.setProductId(1);
		productStore.setProductName("Pen");
		productStore.setStoreId(1);
		listProductStore.add(productStore);

		ProductStoreResponseDto productStoreResponsesDto = new ProductStoreResponseDto();
		List<ProductStoreResponseDto> listProductStoreResponseDto = new ArrayList<>();
		productStoreResponsesDto.setPrice(100);
		productStoreResponsesDto.setProductName("Pen");
		productStoreResponsesDto.setRating(2);

		Mockito.when(productStoreRepository.findByProductName("pen")).thenReturn(listProductStore);
		Mockito.when(storeReviewRepository.findByStoreId(1)).thenReturn(2);
		productStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(productStoreResponsesDto);
		
		listProductStoreResponseDto = productStoreServiceImpl.productDetails("pen");
		assertEquals(1, listProductStoreResponseDto.size());

	}

}
