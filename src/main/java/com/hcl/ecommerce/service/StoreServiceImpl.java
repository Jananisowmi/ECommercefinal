package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.dto.StoreRequestDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.StoreNotFoundException;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * This is StoreServiceImpl class that has 2 methods
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;

	/**
	 * This is saveStore method used to add the StoreDetails
	 */
	@Override
	public String saveStore(StoreRequestDto storeRequestDto) {
		Store store = new Store();
		store.setStoreName(storeRequestDto.getStoreName());
		store.setStoreLocation(storeRequestDto.getStoreLocation());
		store.setContactNumber(storeRequestDto.getContactNumber());
		storeRepository.save(store);
		return ECommerceConstants.STORE_SUCCESS_MESSAGE;
	}

	/**
	 * This is findStoreByStoreId method used to find the StoreId from the store
	 * 
	 * @exception StoreNotFoundException
	 */
	@Override
	public Store findStoreByStoreId(Integer storeId) throws StoreNotFoundException {
		Store store = storeRepository.findStoreByStoreId(storeId);
		if (store == null) {
			throw new StoreNotFoundException("store is not available");
		}
		return store;
	}

}
