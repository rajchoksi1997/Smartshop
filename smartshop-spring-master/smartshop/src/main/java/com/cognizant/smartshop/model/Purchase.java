package com.cognizant.smartshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="purchase_id")
	private int purchaseId;
	
	@Column(name="purchase_date")
	private Date purchaseDate;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="amount")
	private int amount;

	public Purchase() {
		super();
	}

	public Purchase(int purchaseId, Date purchaseDate, String userId, String productCode, int quantity, int amount) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseDate = purchaseDate;
		this.userId = userId;
		this.productCode = productCode;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + purchaseId;
		result = prime * result + quantity;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Purchase other = (Purchase) obj;
		if (amount != other.amount)
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchaseId != other.purchaseId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", purchaseDate=" + purchaseDate + ", userId=" + userId
				+ ", productCode=" + productCode + ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	
}
