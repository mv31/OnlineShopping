package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.OrderDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Order;
import com.app.model.Product;

public class OrderDAOImpl implements OrderDAO{
	
	private static Logger log = Logger.getLogger(CartAddDAOImpl.class);

	@Override
	public int placeOrder(List<Cart> cartList, String orderStatus) throws BusinessException {
		int count = 0, c = 0;
		Order order = new Order();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into `revature_project_1`.`order`(customerId, productId, productName, ratings, cost, orderStatus) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
			for(int i=0;i<cartList.size();i++) {
				double total = 0;
				preparedStatement.setInt(1, cartList.get(i).getCustomerId());
				preparedStatement.setInt(2, cartList.get(i).getProduct().getProductId());
				preparedStatement.setString(3, cartList.get(i).getProduct().getProductName());
				preparedStatement.setDouble(4, cartList.get(i).getProduct().getRatings());
				total = ((cartList.get(i).getProduct().getPrice())*(cartList.get(i).getQuantity()))+total;
				preparedStatement.setDouble(5, total);
				preparedStatement.setString(6, orderStatus);
				c = preparedStatement.executeUpdate();
				if (c == 1) {
					ResultSet resultSet = preparedStatement.getGeneratedKeys();
					if(resultSet.next()) {
						order.setOrderId(resultSet.getInt(1));
					}
					count++;
				}
				else {
					throw new BusinessException("Your order is not placed... kindly retry..");
				}
					
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}

		return count;
	}

	@Override
	public List<Order> getOrderList(int cId) throws BusinessException {
		List<Order> orderList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select orderId, customerId, productId, productName, ratings, cost, orderStatus from `revature_project_1`.`order` where customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("orderId"));
				order.setCustomerId(resultSet.getInt("customerId"));
				order.setProductId(resultSet.getInt("productId"));
				order.setProductName(resultSet.getString("productName"));
				order.setRatings(resultSet.getDouble("ratings"));
				order.setCost(resultSet.getDouble("cost"));
				order.setOrderStatus(resultSet.getString("orderStatus"));
			
				orderList.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return orderList;
	}

}
