package com.cognizant.smartshop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offer")
public class Offer {

	private Date offerDate;
	
	@Id
	private String productCode;
	private int discountedRate;
	private String offerName;
	
	public Offer() {
		super();
	}

	public Offer(Date offerDate, String productCode, int discountedRate, 
			String offerName) {
		super();
		this.offerDate = offerDate;
		this.productCode = productCode;
		this.discountedRate = discountedRate;
		this.offerName = offerName;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getDiscountedRate() {
		return discountedRate;
	}

	public void setDiscountedRate(int discountedRate) {
		this.discountedRate = discountedRate;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + discountedRate;
		result = prime * result + ((offerDate == null) ? 0 : offerDate.hashCode());
		result = prime * result + ((offerName == null) ? 0 : offerName.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
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
		Offer other = (Offer) obj;
		if (discountedRate != other.discountedRate)
			return false;
		if (offerDate == null) {
			if (other.offerDate != null)
				return false;
		} else if (!offerDate.equals(other.offerDate))
			return false;
		if (offerName == null) {
			if (other.offerName != null)
				return false;
		} else if (!offerName.equals(other.offerName))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offer [offerDate=" + offerDate + ", productCode=" + productCode
				+ ", discountedRate=" + discountedRate + ", offerName=" + offerName + "]";
	}
	
	
	
}
