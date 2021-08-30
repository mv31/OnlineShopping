package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductAddDAO {
	public Product addProduct(Product product) throws BusinessException;
	public List<Product> getAllProducts() throws BusinessException;

}
