package com.app.model;

public class Customer {
	private String newName;
	private int cusId;
	private String newEmail;
	private String rePassword;
	private long newPhnumber;
	
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

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public long getNewPhnumber() {
		return newPhnumber;
	}

	public void setNewPhnumber(long newPhnumber) {
		this.newPhnumber = newPhnumber;
	}

	@Override
	public String toString() {
		return "Customer [newName=" + newName + ", cusId=" + cusId + ", newEmail=" + newEmail + ", rePassword="
				+ rePassword + ", newPhnumber=" + newPhnumber + "]";
	}

	
	
	
}
