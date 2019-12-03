package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter

/**
 * * The User class is a pojo class that has 3 fields
 * 
 * @author Janani
 * @since 2019-11-25
 *
 */
public class User {

	@Id
	private Integer userId;
	private String userName;
	private String passWord;

}
