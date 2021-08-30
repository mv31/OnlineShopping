package com.app.product.service.impl;

import java.util.List;

import com.app.dao.ProductDAO;
import com.app.dao.impl.ProductDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.product.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> getAllProducts() throws BusinessException {
		ProductDAO productDao = new ProductDAOImpl();
		
		return productDao.getAllProducts();
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
