package com.cognizant.smartshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.model.Purchase;
import com.cognizant.smartshop.service.PurchaseService;

@RestController
@RequestMapping(value="/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	@GetMapping("/{userId}")
	public List<Purchase> getUserPurchase(@PathVariable String userId) {
		 return purchaseService.getUserPurchase(userId);
		
	}
	
	@PostMapping()
	public void savePurchase(@RequestBody List<Purchase> allPurchase) {
		for(Purchase purchase : allPurchase)
		{
			purchaseService.savePurchase(purchase);
		}
	}

}
