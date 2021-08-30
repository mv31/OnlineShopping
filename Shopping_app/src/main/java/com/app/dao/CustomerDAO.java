package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	public List<Customer> signIn(String Email, String Password) throws BusinessException;
	public Customer signUp(Customer customer) throws BusinessException;


}
