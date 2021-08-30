package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductAddService {
	public String addProduct(Product product) throws BusinessException;
	public String getAllProducts() throws BusinessException;

}
