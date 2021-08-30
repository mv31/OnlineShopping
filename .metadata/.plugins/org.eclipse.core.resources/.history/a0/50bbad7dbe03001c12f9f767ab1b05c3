package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductAddDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductAddDAOImpl implements ProductAddDAO{
	private static Logger log = Logger.getLogger(ProductAddDAOImpl.class);
	@Override
	public Product addProduct(Product product) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into product (prodName, Price, Category) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getProdName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setString(3, product.getCategory());
			c = preparedStatement.executeUpdate();
			if (c == 1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					product.setProductId(resultSet.getInt(1));
					//log.info(c + " row created successfully");
				}
				
			} else {
				throw new BusinessException("Product is not added... kindly retry..");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return product;
	}


	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try(Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select productId, prodName, price, category from product";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProdName(resultSet.getString("prodName"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				productList.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return productList;
	}


}
