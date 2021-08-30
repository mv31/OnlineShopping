package com.app.model;

public class Cart {
	
	private int cusId;
	private int productId;
	private int Quantity;

	private Product product;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int cusQuantity) {
		this.Quantity = cusQuantity;
	}
	public Cart(int cusId, int productId, int quantity, Product product) {
		super();
		this.cusId = cusId;
		this.productId = productId;
		Quantity = quantity;
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cart [cusId=" + cusId + ", productId=" + productId + ", Quantity=" + Quantity + ", product=" + product
				+ "]";
	}
	
	}
	

