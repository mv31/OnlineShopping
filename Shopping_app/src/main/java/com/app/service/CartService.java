package com.app.service;

import com.app.exception.BusinessException;

public interface CartService {
	public String addToCart(int cId, int pId, int quantity) throws BusinessException;
	public String getAllItemsInCart(int cId) throws BusinessException;

}
