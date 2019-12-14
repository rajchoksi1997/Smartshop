package com.cognizant.smartshop.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.Offer;

@Repository
public interface IOfferRepository extends JpaRepository<Offer, Integer>{

	@Modifying
	@Transactional
	@Query(value="UPDATE offer SET offer_date = ?, "
	+"product_code = ?, discounted_rate = ?, offer_name = ? WHERE product_code = ?;"
	+ "UPDATE product SET rate_per_quantity=? WHERE product_code = ?;"
	, nativeQuery=true)
	void updateOffer(Date offerDate, String productCode, int discountedRate, String offerName, 
			String product_code);

	Offer findByProductCode(String productCode);

	
}
