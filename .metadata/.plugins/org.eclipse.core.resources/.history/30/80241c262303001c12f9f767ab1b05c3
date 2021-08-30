package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.OrderDAO;
import com.app.dao.impl.OrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Order;
import com.app.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	OrderDAO orderDAO = new OrderDAOImpl();

	@Override
	public String placeOrder(List<Cart> cartList, String orderStatus) throws BusinessException {
		String actualValue = null;
		int value = 0;
		if(orderStatus.equals("true")) {
			value = orderDAO.placeOrder(cartList, orderStatus);
			if(value == cartList.size()) {
				actualValue = "Order Placed";
			}
		}
		return actualValue;
	}

	@Override
	public String getOrderList(int cId) throws BusinessException {
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
