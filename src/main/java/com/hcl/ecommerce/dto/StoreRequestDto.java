package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * * The StoreRequestDto class is a Dto class that has 3 fields
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
public class StoreRequestDto {

	private String storeName;
	private String storeLocation;
	private String contactNumber;

}
