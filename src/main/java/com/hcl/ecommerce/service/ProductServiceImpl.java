package com.hcl.ecommerce.service;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.constants.ECommerceConstants;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * This is ProductServiceImpl class that has 2 methods
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	ProductStoreRepository productStoreRepository;

	@Autowired
	StoreService storeService;

	@Autowired
	ProductService productService;

	/**
	 * This is saveProduct method .It is responsible for adding the product
	 */
	@Override
	public String saveProduct(String productName) {
		Product product = new Product();
		product.setProductName(productName);
		productRepository.save(product);
		return ECommerceConstants.PRODUCT_SUCCESS_MESSAGE;
	}

	/**
	 * This is findProductByProductName used to find the productName
	 */

	@Override
	public List<Product> findProductByProductName(String productName) {
		List<Product> product = productRepository.findAll();
		List<Product> productByName = new ArrayList<>();
		for (Product products : product) {
			productByName.add(products);

			productByName = productByName.stream().filter(productsByName -> productsByName.getProductName()
					.toLowerCase().startsWith(productName.toLowerCase())).collect(Collectors.toList());
		}
		return productByName;

	}

}
