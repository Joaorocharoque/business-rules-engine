package com.company.businessrulesengine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private int quantity;
	private LocalDate expirationDate;
	private Double purchasePrice;
	private Double salePrice;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public static final class Builder {
		private Long id;
		private String name;
		private String description;
		private int quantity;
		private LocalDate expirationDate;
		private Double purchasePrice;
		private Double salePrice;

		private Builder() {
		}

		public static Builder aProduct() {
			return new Builder();
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder quantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder expirationDate(LocalDate expirationDate) {
			this.expirationDate = expirationDate;
			return this;
		}

		public Builder purchasePrice(Double purchasePrice) {
			this.purchasePrice = purchasePrice;
			return this;
		}

		public Builder salePrice(Double salePrice) {
			this.salePrice = salePrice;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.id = this.id;
			product.expirationDate = this.expirationDate;
			product.quantity = this.quantity;
			product.description = this.description;
			product.salePrice = this.salePrice;
			product.purchasePrice = this.purchasePrice;
			product.name = this.name;
			return product;
		}
	}
}