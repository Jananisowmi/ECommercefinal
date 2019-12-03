package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.entity.Product;

public interface ProductService {

	String saveProduct(String productName);

	List<Product> findProductByProductName(String productName);

}
