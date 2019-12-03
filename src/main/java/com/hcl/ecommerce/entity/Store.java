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
@Table(name = "store")
@Getter
@Setter
@SequenceGenerator(name = "sequence", initialValue = 100)

/**
 * * The Store class is a pojo class that has 4 fields
 * @author Janani
 * @since 2019-11-25
 *
 */

public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	private Integer storeId;
	private String storeName;
	private String storeLocation;
	private String contactNumber;

}
