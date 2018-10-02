package com.prs.business.purchaserequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.prs.business.product.Product;

@Entity 
public class PurchaseRequestLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "purchaseRequestId")
	private PurchaseRequest purchaceRequest;
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;
	private int quantity;
	
	public PurchaseRequestLineItem(int id, PurchaseRequest purchaceRequest, Product product, int quantity) {
		super();
		this.id = id;
		this.purchaceRequest = purchaceRequest;
		this.product = product;
		this.quantity = quantity;
	}

	public PurchaseRequestLineItem() {
		super();
	}

	public PurchaseRequestLineItem(PurchaseRequest purchaceRequest, Product product, int quantity) {
		super();
		this.purchaceRequest = purchaceRequest;
		this.product = product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PurchaseRequest getPurchaceRequest() {
		return purchaceRequest;
	}

	public void setPurchaceRequest(PurchaseRequest purchaceRequest) {
		this.purchaceRequest = purchaceRequest;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaceRequestLineItem [id=" + id + ", purchaceRequest=" + purchaceRequest + ", product="
				+ product + ", quantity=" + quantity + "]";
	}
	
	
	
	
}