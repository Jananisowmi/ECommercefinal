package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.ProductStore;

@Repository
public interface StoreReviewRepository extends JpaRepository<ProductStore, Integer> {

	@Query("SELECT AVG(s.rating) FROM StoreReview s where s.storeId=?1")
	Integer findByStoreId(Integer storeId);

}
