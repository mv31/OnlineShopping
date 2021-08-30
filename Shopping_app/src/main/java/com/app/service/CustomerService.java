package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerService {
	public String signIn(String email, String password) throws BusinessException;
	public String signUp(Customer customer) throws BusinessException;

}
