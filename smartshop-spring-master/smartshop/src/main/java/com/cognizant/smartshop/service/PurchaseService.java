package com.cognizant.smartshop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.model.Purchase;
import com.cognizant.smartshop.repository.IPurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	IPurchaseRepository purchaseRepository;
	
	public List<Purchase> getUserPurchase(String userId) {
		return purchaseRepository.getUserPurchase(userId);
	}

	public void savePurchase(Purchase purchase) {
		purchase.setPurchaseDate(new Date());
		purchaseRepository.save(purchase);
	}


}
