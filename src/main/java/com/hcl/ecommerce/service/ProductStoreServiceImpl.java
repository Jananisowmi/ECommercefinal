package com.hcl.ecommerce.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductStoreResponseDto;
import com.hcl.ecommerce.entity.ProductStore;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.StoreReviewRepository;

/**
 * This is ProductStoreServiceImpl class that has 1 method
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */

@Service
public class ProductStoreServiceImpl implements ProductStoreService {
	@Autowired
	ProductStoreRepository productStoreRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	StoreReviewRepository storeReviewRepository;
	
	/**
	 * This is productDetails used to find the productDetails from the productStore
	 */

	@Override
	public List<ProductStoreResponseDto> productDetails(String productName) {
		List<ProductStore> productStores = productStoreRepository.findByProductName(productName);
		List<ProductStoreResponseDto> productStoreResponseDto = new ArrayList<>();
		for (ProductStore productStore : productStores) {
		
			ProductStoreResponseDto productStoreResponsesDto = new ProductStoreResponseDto();
			productStoreResponsesDto.setProductName(productStore.getProductName());
			productStoreResponsesDto.setStoreId(productStore.getStoreId());
			productStoreResponsesDto.setPrice(productStore.getPrice());
			productStoreResponsesDto.setRating(storeReviewRepository.findByStoreId(productStore.getStoreId()));
			productStoreResponseDto.add(productStoreResponsesDto);
		}
		return productStoreResponseDto;
	}
}
