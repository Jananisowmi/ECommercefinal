package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_store")
@Getter
@Setter

/**
 * * The ProductStore class is a pojo class that has 5 fields
 * @author Janani
 * @since 2019-11-25
 *
 */
public class ProductStore {

	@Id
	private Integer id;
	private Integer productId;
	private String productName;
	private Integer storeId;
	private double price;

}
