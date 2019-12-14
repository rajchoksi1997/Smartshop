package com.cognizant.smartshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.Purchase;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query(value="SELECT p.purchase_id,p.purchase_date,p.user_id,p.product_code,p.quantity,p.amount FROM purchase p WHERE p.user_id=? ORDER BY p.purchase_date DESC", nativeQuery=true)
	public List<Purchase> getUserPurchase(String userId);

}
