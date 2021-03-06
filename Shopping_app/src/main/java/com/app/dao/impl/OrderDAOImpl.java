package com.app.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;


import com.app.dao.OrderDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.model.Cart;

public class OrderDAOImpl implements OrderDAO{
	private static Logger log = Logger.getLogger(CartDAOImpl.class);

	@Override
	public List<Order> getOrderList(int cId) throws BusinessException {
		// TODO Auto-generated method stub
		List<Order> orderList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select orderId, custId, prodId, prodName, category, totalPrice from `shop`.`order` where cusId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderId"));
				order.setCusId(resultSet.getInt("cusId"));
				order.setProductId(resultSet.getInt("productId"));
				order.setProdName(resultSet.getString("prodName"));
				order.setCategory(resultSet.getString("category"));
				order.setTotalPrice(resultSet.getDouble("totalPrice"));
				
			
				orderList.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return orderList;
		
	}
	

}
