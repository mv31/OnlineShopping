package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.OrderDAO;
import com.app.dao.impl.OrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDAO orderDAO = new OrderDAOImpl();

	@Override
	public String getOrderList(int cId) throws BusinessException {
		// TODO Auto-generated method stub
		String actualValue = null;
		List<Order> orderList = new ArrayList<>();
		orderList = orderDAO.getOrderList(cId);
		if(orderList.isEmpty()) {
			throw new BusinessException("There is some error in getting order list.. Please retry..");
		}
		else {
			actualValue = "Order List Shown";
		}
		return actualValue;
		
	}

}
