package com.app.model;

public class Customer {
	private String newName;
	private int cusId;
	private String newEmail;
	private String newPassword;
	private long newPhnumber;
	
	public Customer(String name, String email, String password, long phnumber) {
		// TODO Auto-generated constructor stub
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

//	public Customer(String newName, int cusId, String newEmail, String newPassword, long newPhnumber) {
//		super();
//		this.newName = newName;
//		this.cusId = cusId;
//		this.newEmail = newEmail;
//		this.newPassword = newPassword;
//		this.newPhnumber = newPhnumber;
//	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public long getNewPhnumber() {
		return newPhnumber;
	}

	public void setNewPhnumber(long newPhnumber) {
		this.newPhnumber = newPhnumber;
	}

	@Override
	public String toString() {
		return "Customer [newName=" + newName + ", cusId=" + cusId + ", newEmail=" + newEmail + ", newPassword="
				+ newPassword + ", newPhnumber=" + newPhnumber + "]";
	}

	
	
	
	
}
