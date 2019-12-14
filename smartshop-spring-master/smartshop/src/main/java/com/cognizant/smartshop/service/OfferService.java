package com.cognizant.smartshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.model.Offer;
import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.repository.IOfferRepository;
import com.cognizant.smartshop.repository.IProductRepository;

@Service
public class OfferService {
	
	@Autowired
	IOfferRepository offerRepository;
	
	@Autowired
	IProductRepository productRepository;
	
	public List<Offer> getAllOffers() {
		return offerRepository.findAll();
	}

	public void insertOffer(Offer offer) {
		int ratePerQuantity = offer.getDiscountedRate();
		String productCode = offer.getProductCode();
		offerRepository.save(offer);
		Product product = productRepository.findByProductCode(productCode);
		product.setRatePerQuantity(ratePerQuantity);
		productRepository.save(product);
		
	}

	public void updateOffer(Offer offer) {
		int ratePerQuantity = offer.getDiscountedRate();
		String productCode = offer.getProductCode();
		offerRepository.updateOffer(offer.getOfferDate(), offer.getProductCode(), 
			offer.getDiscountedRate(), offer.getOfferName(), offer.getProductCode());
		Product product = productRepository.findByProductCode(productCode);
		product.setRatePerQuantity(ratePerQuantity);
		productRepository.save(product);
		
	}

	public void deleteOffer(String productCode) {
		Offer offer = offerRepository.findByProductCode(productCode);
		offerRepository.delete(offer);
	}

	public Offer getOfferByProductCode(String productCode) {
		System.out.println("aspdjas;d;lasmd;lasmd;lasmd;lasm;lsamd;lamd;lasm;ldsam;ldmsa"+offerRepository.findByProductCode(productCode));
		return offerRepository.findByProductCode(productCode);
	}

}
