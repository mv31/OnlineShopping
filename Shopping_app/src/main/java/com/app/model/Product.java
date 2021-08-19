package com.app.model;

	public class Product {
		private int productId;
		private String name;
		private String category;
		private double price;
		private int quantity;
		private String desc;
		

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
					+ ", quantity=" + quantity + ", desc=" + desc + "]";
		}

		

	}



