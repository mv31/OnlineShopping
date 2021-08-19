package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.ProductDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;

//import com.app.model.Player;
import com.app.model.Product;
//import com.app.model.Team;

public class ProductDAOImpl implements ProductDAO{
@Override
	public List<Product> getAllProducts() throws BusinessException {
		// TODO Auto-generated method stub
		List<Product> ProductList =new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select p.productId,name,category,price,quantity from product ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product =new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				
				ProductList.add(product);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);//this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return ProductList ;
	}
	 
@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
