package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 * * The UserOrderDto class is a Dto class that has 3 fields
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
public class UserOrderDto {

	private Integer userId;
	private String storeName;
	private String productName;

}
