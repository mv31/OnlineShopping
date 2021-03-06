package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.ProductSearchService;

public class ProductSearchServiceImpl implements ProductSearchService {
	public ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();

	@Override
	public Product getProductById(int productId) throws BusinessException {
		Product product = null;
		if(productId < 1 || productId > 1000) {
			throw new BusinessException("Invalid Producr ID "+productId);
		}
		else {
			product = productSearchDAO.getProductById(productId);
			
		}
		return product;
	}

	@Override
	public List<Product> getProductsByProdName(String prodName) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		if(prodName.matches("[a-zA-Z]{2,15}")) {
			productList = productSearchDAO.getProductsByName(prodName);
		}
		else {
			throw new BusinessException("Invalid Product Name "+prodName);
		}
		
		return productList;
	}

	@Override
	public List<Product> getProductsByPrice(double price) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		if(price < 0) {
			throw new BusinessException("Invalid Product price "+price);
		}
		else {
			productList = productSearchDAO.getProductsByPrice(price);
		}
		
		return productList;
	}

@Override
	public List<Product> getProductsByCategory(String category) throws BusinessException {
		List<Product> productList = new ArrayList<>();
//		if(ratings < 1 || ratings > 5) {
//			throw new BusinessException("Invalid Product ratings "+category);
//		}
//		else {
//			productList = productSearchDAO.getProductsByCategory(category);
//		}
//		
		return productList;
	}

}
