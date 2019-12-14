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

import com.cognizant.smartshop.model.Purchase;
import com.cognizant.smartshop.repository.IPurchaseRepository;
import com.cognizant.smartshop.service.PurchaseService;

public class TestPurchase {

	@Mock
	private IPurchaseRepository pruchaseRepository;

	@InjectMocks
	private PurchaseService purchaseService;

	Purchase purchase = new Purchase();
	List<Purchase> purchases = new ArrayList<>();

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void getUserPurchaseTest() {
		String userId = "U001";
		purchase.setPurchaseId(1);
		purchase.setPurchaseDate(null);
		purchase.setUserId(userId);
		purchase.setProductCode("P001");
		purchase.setQuantity(5);
		purchase.setAmount(500);

		purchases.add(purchase);

		when(pruchaseRepository.getUserPurchase("U001")).thenReturn(purchases);
		assertEquals(purchases, purchaseService.getUserPurchase(userId));
	}

}
