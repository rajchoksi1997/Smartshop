package com.cognizant.mockito.service;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.cognizant.smartshop.model.Offer;
import com.cognizant.smartshop.repository.IOfferRepository;
import com.cognizant.smartshop.service.OfferService;


public class TestOffer {

	@Mock
	private IOfferRepository offerRepository;

	@InjectMocks
	private OfferService offerService;

	Offer offer = new Offer();
	List<Offer> offers = new ArrayList<>();

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void getAllOffersTest() {
		offer.setOfferDate(null);
		offer.setDiscountedRate(500);
		offer.setOfferName("Bonanza");
		offer.setProductCode("P001");

		offers.add(offer);

		when(offerRepository.findAll()).thenReturn(offers);
		assertEquals(offers, offerService.getAllOffers());
	}

}
