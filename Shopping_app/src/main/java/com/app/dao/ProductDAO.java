package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductDAO {
	public List<Product> getAllProducts() throws BusinessException;
	public Product getById(int id);

}