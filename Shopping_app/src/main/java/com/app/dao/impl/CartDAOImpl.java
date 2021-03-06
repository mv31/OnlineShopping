package com.app.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;


public class CartDAOImpl implements CartDAO {
	private static Logger log = Logger.getLogger(CartDAOImpl.class);


	@Override
	public Cart addToCart(int cId, int pId, int quantity) throws BusinessException {
		// TODO Auto-generated method stub
		int c = 0;
		Cart cart = new Cart();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into cart (cusId, productId, quantity) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cId);
			preparedStatement.setInt(2, pId);
			preparedStatement.setInt(3, quantity);
			c = preparedStatement.executeUpdate();
			
//			if (c == 1) {
//				ResultSet resultSet = preparedStatement.getGeneratedKeys();
//				if(resultSet.next()) {
//					cart.setCartId(resultSet.getInt(1));
//					//log.info(c + " row created successfully");
//				}
				
			if(c != 1) {
				throw new BusinessException("Product is not added in Cart... kindly retry..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		return cart;
		
	}

	@Override
	public List<Cart> getAllItemsInCart(int cId) throws BusinessException {
		// TODO Auto-generated method stub
		List<Cart> cartList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select c.cusId, p.prodId, prodName, price, category, quantity from product p join cart c on c.cusId = ? where p.prodId=c.prodId";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProdName(resultSet.getString("prodName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				Cart cart = new Cart();
				cart.setCusId(resultSet.getInt("cusId"));
				cart.setQuantity(resultSet.getInt("quantity"));
				cart.setProduct(product);
				cartList.add(cart);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		
		return cartList;
		
	}

}
