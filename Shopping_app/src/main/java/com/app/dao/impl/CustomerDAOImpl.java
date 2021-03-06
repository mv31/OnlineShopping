package com.app.dao.impl;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public List<Customer> signIn(String Email, String Password) throws BusinessException {
		// TODO Auto-generated method stub
		List<Customer> cusList= new ArrayList<>();
		Customer customer = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select cusId, newName, newEmail, newPassword, newPhnumber from customer where newEmail = ? and newPassword = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Email);
			preparedStatement.setString(2, Password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customer = new Customer();
				customer.setCusId(resultSet.getInt("cusId"));
				customer.setNewName(resultSet.getString("newName"));
				customer.setNewEmail(resultSet.getString("newEmail"));
				customer.setNewEmail(resultSet.getString("newPassword"));
				customer.setNewPhnumber(resultSet.getLong("newPhnumber"));
				cusList.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured, Please contact admin");
		}
		
		return cusList;
		
	}

	@Override
	public Customer signUp(Customer customer) throws BusinessException {
		// TODO Auto-generated method stub
		System.out.println(customer);
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into customer (newName, newEmail, newPassword, newPhnumber) values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customer.getNewName());
			preparedStatement.setString(2, customer.getNewEmail());
			preparedStatement.setString(3, customer.getNewPassword());
			preparedStatement.setLong(4, customer.getNewPhnumber());
			c = preparedStatement.executeUpdate();
			if (c == 1) {
			
			
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next()) {
					customer.setCusId(resultSet.getInt(1));
					log.info(c + " row created successfully");
				}
				
			 if(c!=1) {
				throw new BusinessException("SignUp Unsuccessfull, Kindly Register again...");
			}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		return customer;
	}

	
		
	

	
	
}
