package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "store_review")
@Getter
@Setter

/**
 * * The StoreReview class is a pojo class that has 4 fields
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
public class StoreReview {

	@Id
	private Integer reviewId;
	private Integer userId;
	private Integer storeId;
	private Integer rating;

}
