package com.cognizant.smartshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smartshop.model.Product;
import com.cognizant.smartshop.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = {"/sorted/name", "/sorted/name/{productType}"})
	public List<Product> getProductsSortedByName(@PathVariable Optional<String> productType) {
		if(productType.isPresent())
		{
		return productService.getProductsSortedByNameWithProductType(productType);
		}
		else
		{
			return productService.getProductsSortedByName();
		}
	}
	
	@GetMapping(value = {"/sorted/availability", "/sorted/availability/{productType}"})
	public List<Product> getProductsSortedByAvailability(@PathVariable Optional<String> productType) {
		
		if(productType.isPresent())
		{
			return productService.getProductsSortedByAvailabilityWithProductType(productType);		
		}
		else
		{
			return productService.getProductsSortedByAvailability();		
		}
	}
	
	@GetMapping(value = {"/sorted/price","/sorted/price/{productType}"})
	public List<Product> getProductsSortedByPrice(@PathVariable Optional<String> productType) {
		
		if(productType.isPresent())
		{
			return productService.getProductsSortedByPriceWithProductType(productType);
		}
		else
		{
			return productService.getProductsSortedByPrice();
		}
		
	}
	
	@GetMapping(value = {"/sorted/popularity","/sorted/popularity/{productType}"})
	public List<Product> getProductsSortedByPopularity(@PathVariable Optional<String> productType) {
		
		if(productType.isPresent())
		{
			return productService.getProductsSortedByPopularityWithProductType(productType);
		}
		else
		{
			return productService.getProductsSortedByPopularity();
		}
		
	}
	
	@GetMapping("/{productCode}")
	public Product getProductByCode(@PathVariable("productCode") String productCode){
		return productService.getProductByCode(productCode);
	}
	
	@GetMapping("/newproducts")
	public List<Product> getNewProducts(){
		return productService.getNewProducts();
	}
	
	
	@GetMapping("/productType/{productType}")
	public List<Product> getProductsByProductType(@PathVariable("productType") String productType) {
		return productService.getProductsByProductType(productType);
	}
	
	@GetMapping("/{productName}/{userId}")
	public Product getProductByName(@PathVariable("productName") String productCode,
			@PathVariable("userId") String userId ){
		return productService.getProductByName(productCode, userId);
	}
	
	@PostMapping()
	public void addProduct(@RequestBody Product product){
		System.out.println(product);
		productService.addProduct(product);
	}
	
	@PutMapping()
	public void updateProduct(@RequestBody Product product) {
		System.out.println("Update product"+product);
		productService.updateProduct(product);
	}
	
	@DeleteMapping("/{productCode}")
	public boolean deleteProduct(@PathVariable("productCode") String productCode) {
		return productService.deleteProduct(productCode);
	}
	
}
