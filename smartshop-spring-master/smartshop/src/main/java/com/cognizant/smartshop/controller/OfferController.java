package com.cognizant.smartshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.model.Offer;
import com.cognizant.smartshop.service.OfferService;

@RestController
@RequestMapping(value="/offers")
public class OfferController {

	@Autowired
	OfferService offerService;
	
	@GetMapping()
	public List<Offer> getAllOffers() {
		return offerService.getAllOffers();
	}
	
	@GetMapping("/{productCode}")
	public Offer getOfferByProductCode(@PathVariable("productCode") String productCode) {
		return offerService.getOfferByProductCode(productCode);
	}
	
	@PostMapping()
	public void insertOffer(@RequestBody Offer offer) {
		offerService.insertOffer(offer);
	}
	
	@PutMapping() 
	public void updateOffer(@RequestBody Offer offer) {
		offerService.updateOffer(offer);
	}
	
	@DeleteMapping("/{productCode}")
	public void deleteOffer(@PathVariable String productCode) {
		offerService.deleteOffer(productCode);
	}
}
