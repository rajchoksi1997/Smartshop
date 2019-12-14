package com.cognizant.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.repository.IProductRepository;
import com.cognizant.smartshop.service.ProductService;


public class TestProduct {
	
	@Mock
	private IProductRepository productRepository;

	
	@InjectMocks
	private ProductService productService;
	
	Product product = new Product();
	
	List<Product> products = new ArrayList<>();
	
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	
	@Test
	public void findAllProuctTest(){
		product.setProductCode("P001");
		product.setProductName("iPhone");
		product.setProductType("Electronics");
		product.setBrand("Apple");
		product.setRatePerQuantity(50000);
		product.setStockCount(5);
		product.setAddDate(null);
		product.setAisle("Right Aisle");
		product.setShelf("Left");
		product.setDateOfManf(null);
		product.setDateOfExp(null);
		product.setProductImg("This is the Image");
		productRepository.save(product);
		products.add(product);
		when(productRepository.findAll()).thenReturn(products);
		assertEquals(products, productService.getAllProducts());
		
	}
	
	@Test
	public void getByProductCode(){
		product.setProductCode("P001");
		product.setProductName("iPhone");
		product.setProductType("Electronics");
		product.setBrand("Apple");
		product.setRatePerQuantity(50000);
		product.setStockCount(5);
		product.setAddDate(null);
		product.setAisle("Right Aisle");
		product.setShelf("Left");
		product.setDateOfManf(null);
		product.setDateOfExp(null);
		product.setProductImg("This is the Image");
		productRepository.save(product);
		products.add(product);
		when(productRepository.findByProductCode("P001")).thenReturn(product);
		assertEquals(product,productService.getProductByCode("P001"));
	}

}
