package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.ProductAddDAO;
import com.app.dao.impl.ProductAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.ProductAddService;

public class ProductAddServiceImpl implements ProductAddService {
	ProductAddDAO productAddDAO = new ProductAddDAOImpl();
	@Override
	public String addProduct(Product product) throws BusinessException {
		String actualValue = null;
		Product productAddCheck = productAddDAO.addProduct(product);
		if(productAddCheck == null) {
			throw new BusinessException("There is some error in adding the Products.. Please retry..");
		}
		else {
			
			actualValue = "Product added successfully";
		}
		return actualValue;
	}

	@Override
	public String getAllProducts() throws BusinessException {
		String actualValue = null;
		List<Product> productList = new ArrayList<>();
		productList = productAddDAO.getAllProducts();
		if(productList.isEmpty()) {
			throw new BusinessException("There is no Product in the List... kindly add Products...");
		}
		else {
			actualValue = "Product List is Shown";
		}
		return actualValue;
	}

	

}
