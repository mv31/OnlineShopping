package com.app.model;

public class Order {
	private int orderId;
	private int cusId;
	private int productId;
	private String prodName;
	private String category;
	private double totalPrice;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Order(int orderId, int cusId, int productId, String prodName, String category, double totalPrice) {
		super();
		this.orderId = orderId;
		this.cusId = cusId;
		this.productId = productId;
		this.prodName = prodName;
		this.category = category;
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cusId=" + cusId + ", productId=" + productId + ", prodName=" + prodName
				+ ", category=" + category + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
