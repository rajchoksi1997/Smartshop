package com.cognizant.smartshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_type")
	private String productType;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="rate_per_quantity")
	private float ratePerQuantity;
	
	@Column(name="stock_count")
	private int stockCount;
	
	@Column(name="add_date")
	private Date addDate;
	
	@Column(name="aisle")
	private String aisle;
	
	@Column(name="shelf")
	private String shelf;
	
	@Column(name="date_of_manf")
	private Date dateOfManf;
	
	@Column(name="date_of_exp")
	private Date dateOfExp;
	
	@Column(name="product_img")
	private String productImg;
	
	public Product() {
		super();
	}

	public Product(String productCode, String productName, String productType, String brand, float ratePerQuantity,
			int stockCount, Date addDate, String aisle, String shelf, Date dateOfManf, Date dateOfExp,
			String productImg) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.brand = brand;
		this.ratePerQuantity = ratePerQuantity;
		this.stockCount = stockCount;
		this.addDate = addDate;
		this.aisle = aisle;
		this.shelf = shelf;
		this.dateOfManf = dateOfManf;
		this.dateOfExp = dateOfExp;
		this.productImg = productImg;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getRatePerQuantity() {
		return ratePerQuantity;
	}

	public void setRatePerQuantity(float ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Date getDateOfManf() {
		return dateOfManf;
	}

	public void setDateOfManf(Date dateOfManf) {
		this.dateOfManf = dateOfManf;
	}

	public Date getDateOfExp() {
		return dateOfExp;
	}

	public void setDateOfExp(Date dateOfExp) {
		this.dateOfExp = dateOfExp;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addDate == null) ? 0 : addDate.hashCode());
		result = prime * result + ((aisle == null) ? 0 : aisle.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((dateOfExp == null) ? 0 : dateOfExp.hashCode());
		result = prime * result + ((dateOfManf == null) ? 0 : dateOfManf.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((productImg == null) ? 0 : productImg.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + Float.floatToIntBits(ratePerQuantity);
		result = prime * result + ((shelf == null) ? 0 : shelf.hashCode());
		result = prime * result + stockCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (addDate == null) {
			if (other.addDate != null)
				return false;
		} else if (!addDate.equals(other.addDate))
			return false;
		if (aisle == null) {
			if (other.aisle != null)
				return false;
		} else if (!aisle.equals(other.aisle))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (dateOfExp == null) {
			if (other.dateOfExp != null)
				return false;
		} else if (!dateOfExp.equals(other.dateOfExp))
			return false;
		if (dateOfManf == null) {
			if (other.dateOfManf != null)
				return false;
		} else if (!dateOfManf.equals(other.dateOfManf))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productImg == null) {
			if (other.productImg != null)
				return false;
		} else if (!productImg.equals(other.productImg))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (Float.floatToIntBits(ratePerQuantity) != Float.floatToIntBits(other.ratePerQuantity))
			return false;
		if (shelf == null) {
			if (other.shelf != null)
				return false;
		} else if (!shelf.equals(other.shelf))
			return false;
		if (stockCount != other.stockCount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productType=" + productType
				+ ", brand=" + brand + ", ratePerQuantity=" + ratePerQuantity + ", stockCount=" + stockCount
				+ ", addDate=" + addDate + ", aisle=" + aisle + ", shelf=" + shelf + ", dateOfManf=" + dateOfManf
				+ ", dateOfExp=" + dateOfExp + ", productImg=" + productImg + "]";
	}

	
}
