package com.app.model;

	public class Product {
		private int productId;
		private String prodName;
		private String category;
		private double price;
		
		

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Product(String productName, double price2, String category2) {
			// TODO Auto-generated constructor stub
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getProdName() {
			return prodName;
		}

		public void setProdName(String name) {
			this.prodName = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + prodName + ", category=" + category + ", price=" + price
					+ "]";
		}

		

	}



