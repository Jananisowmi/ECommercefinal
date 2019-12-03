package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 * * The ProductStoreResponseDto class is a Dto class that has 4 fields
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
public class ProductStoreResponseDto {

	private String productName;
	private Integer storeId;
	private double price;
	private Integer rating;

}
