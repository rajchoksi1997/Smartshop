package com.cognizant.smartshop.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{
	
	/*@Query(value="SELECT product_code, product_name, product_type, brand, quantity," 
	+ "rate_per_quantity, stock_count, add_date, aisle,"
	+ "shelf, date_of_manf, date_of_exp, product_img "
	+ "FROM product WHERE product_code=?;", nativeQuery=true)*/
	public Product findByProductCode(String productCode);
	
	public Product findByProductName(String productName);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO search (search_date, user_id, product_name) VALUES "
			+ "(CURDATE(),?,?);", nativeQuery=true)
	public void insertSearchRecord(String userId, String productName);

	
	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p "
			+ "WHERE p.product_type=?", nativeQuery=true)
	public List<Product> findByProductType(String productType);

	
	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p ORDER BY p.product_name", nativeQuery=true)
	public List<Product> getProductsSortedByName();
	
	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p WHERE p.product_type=? ORDER BY p.product_name", nativeQuery=true)
	public List<Product> getProductsSortedByNameWithProductType(Optional<String> productType);

	
	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p ORDER BY p.stock_count DESC", nativeQuery=true)
	public List<Product> getProductsSortedByAvailability();
	
	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p WHERE p.product_type=? ORDER BY p.stock_count DESC", nativeQuery=true)
	public List<Product> getProductsSortedByAvailabilityWithProductType(Optional<String> productType);

	
	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p ORDER BY p.rate_per_quantity", nativeQuery=true)
	public List<Product> getProductsSortedByPrice();

	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p WHERE p.product_type=? ORDER BY p.rate_per_quantity", nativeQuery=true)
	public List<Product> getProductsSortedByPriceWithProductType(String productType);

	
	@Query(value="(SELECT product_code FROM purchase GROUP BY product_code ORDER BY COUNT(purchase_id) DESC) ", nativeQuery=true)
	public String[] getProductsSortedByPopularity();

	@Query(value="(SELECT product_code FROM purchase WHERE product_code IN (SELECT product_code FROM product WHERE product_type =?) GROUP BY product_code ORDER BY COUNT(purchase_id) DESC) ", nativeQuery=true)
	public String[] getProductsSortedByPopularityWithProductType(Optional<String> productType);

	@Query(value="SELECT p.product_code, p.product_name, p.product_type, brand, "
			+ "p.rate_per_quantity, p.stock_count, p.add_date, p.aisle, p.shelf, "
			+ "p.date_of_manf, p.date_of_exp, p.product_img FROM product p WHERE (CURDATE() - p.add_date) < 8",nativeQuery=true)
	public List<Product> getNewProducts();

	@Transactional
	@Modifying
	public void deleteByProductCode(String productCode);


}
