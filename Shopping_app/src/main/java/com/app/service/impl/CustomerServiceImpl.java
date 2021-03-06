package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public String signIn(String email, String password) throws BusinessException {
		// TODO Auto-generated method stub
		String actualValue = "";
		List<Customer> cusList = new ArrayList<>();
		cusList = customerDAO.signIn(email, password); 
		if(cusList.isEmpty()) {
			throw new BusinessException("You are not an existing cutomer.. kindly register first..");

		}
		else {
			actualValue = "SignIn Successfull";
		}
		
		
		return actualValue;
		
	}

	@Override
	public String signUp(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
String actualValue = null;
		
		Customer customerValidate = customerDAO.signUp(customer);
		if(customerValidate != null) {
			actualValue = "SignUp Successfull";
		}
		else {
			throw new BusinessException("Your Registration is Incomplete...");
		
		}
		return actualValue;
		
	}
}

	

	
	