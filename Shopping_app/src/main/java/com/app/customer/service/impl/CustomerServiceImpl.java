package com.app.customer.service.impl;

import com.app.customer.service.CustomerService;
import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	@Override
   public  int validateCustomerSignup(Customer customer) throws BusinessException {
		if(customer.getNewEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z.]+$")) {
			return customerDAO.createCustomer(customer);
		}
		else {
			throw new BusinessException("invalid email id");
		}
	
	}
	
	

}