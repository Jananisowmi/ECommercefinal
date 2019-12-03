package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_order")
@Getter
@Setter
@SequenceGenerator(name = "sequence", initialValue = 1)

/**
 * * The UserOrder class is a pojo class that has 7 fields
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	private Integer orderId;
	private Integer storeId;
	private Integer userId;
	private String userName;
	private String productName;
	private String storeName;
	private double price;

}
