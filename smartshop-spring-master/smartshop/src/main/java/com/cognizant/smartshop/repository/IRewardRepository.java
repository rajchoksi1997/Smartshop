package com.cognizant.smartshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.Product;

@Repository
public interface IRewardRepository extends JpaRepository<Product, Long>{

	@Query(value="SELECT r.points FROM reward r WHERE r.user_id=?", nativeQuery=true)
	int getRewardPoints(String userId);

	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO reward VALUES(?,?) ON DUPLICATE KEY UPDATE points=?",nativeQuery=true)
	void updateRewardPoints(String userId,int points,int points1);
	
}
