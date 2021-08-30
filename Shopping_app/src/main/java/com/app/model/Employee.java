package com.app.model;

public class Employee {
	String userName;
	String passWord;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Employee(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String logIn(String employeeUsername, String employeePassword) {
		String loginMessage="";
		String username = "manojmv4811";
		String password = "12345";
		if(employeeUsername.equals(username) && employeePassword.equals(password)) {
			loginMessage = "LogIn Successfull";
		}
		return loginMessage;
	}
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", passWord=" + passWord + "]";
	}

}
