
package com.app.product.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductService {
	public List<Product> getAllProducts() throws BusinessException;
	public Product getById(int id);
	


}
