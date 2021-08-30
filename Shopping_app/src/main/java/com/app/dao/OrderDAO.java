package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface OrderDAO {
	public List<Order> getOrderList(int cId) throws BusinessException;


}
