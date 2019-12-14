package com.cognizant.smartshop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepository;
	
	public ProductService(){
		
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	
	public Product getProductByCode(String productCode) {
		return productRepository.findByProductCode(productCode);
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void updateProduct(Product product) {
		product.setAddDate(new Date());
		productRepository.save(product);
	}
	
	public boolean deleteProduct(String productCode) {
		productRepository.deleteByProductCode(productCode);
		if(productRepository.findByProductCode(productCode) != null)
			return false;
		return true;
	}

	public Product getProductByName(String productName, String userId) {
		productRepository.insertSearchRecord(userId, productName);
		return productRepository.findByProductName(productName);
	}

	public List<Product> getProductsByProductType(String productType) {
		return productRepository.findByProductType(productType);
	}

	public List<Product> getProductsSortedByName() {
		return productRepository.getProductsSortedByName();
	}
	
	public List<Product> getProductsSortedByNameWithProductType(Optional<String> productType) {
		return productRepository.getProductsSortedByNameWithProductType(productType);
	}

	public List<Product> getProductsSortedByAvailability() {
		return productRepository.getProductsSortedByAvailability();
	}
	
	public List<Product> getProductsSortedByAvailabilityWithProductType(Optional<String> productType) {
		return productRepository.getProductsSortedByAvailabilityWithProductType(productType);
	}


	public List<Product> getProductsSortedByPrice() {
		return productRepository.getProductsSortedByPrice();
	}
	
	public List<Product> getProductsSortedByPriceWithProductType(Optional<String> productType) {
		return productRepository.getProductsSortedByPriceWithProductType(productType.get());
	}
	

	public List<Product> getProductsSortedByPopularity() {
		
		String[] productCodeList= productRepository.getProductsSortedByPopularity();
		
		List<Product> productList = new ArrayList<>();
		
		for(String productCode : productCodeList)
		{
			productList.add(productRepository.findByProductCode(productCode));
		}
		return productList;
	}

	public List<Product> getProductsSortedByPopularityWithProductType(Optional<String> productType) {
		String[] productCodeList= productRepository.getProductsSortedByPopularityWithProductType(productType);
		
		List<Product> productList = new ArrayList<>();
		
		for(String productCode : productCodeList)
		{
			productList.add(productRepository.findByProductCode(productCode));
		}
		return productList;
	}

	public List<Product> getNewProducts() {
		return productRepository.getNewProducts();
	}

	
}
