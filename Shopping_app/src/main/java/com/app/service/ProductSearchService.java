package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductSearchService {
	public Product getProductById(int productId) throws BusinessException;
	public List<Product> getProductsByProdName(String prodName) throws BusinessException;
	public List<Product> getProductsByPrice(double price) throws BusinessException;
	public List<Product> getProductsByCategory(String category) throws BusinessException;


}
