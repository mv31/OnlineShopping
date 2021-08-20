package com.app.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		//Customer customer = null;
	try(Connection connection  = MySqlDbConnection.getConnection()){
		int c;
		String sql = "insert into customer(cusid,name,newEmail,newPassword,newPhnumber) values (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, customer.getCusId());
		preparedStatement.setString(2, customer.getNewName());
		preparedStatement.setString(3, customer.getNewEmail());
		preparedStatement.setString(4, customer.getRePassword());
		preparedStatement.setLong(5, customer.getNewPhnumber());
		c=preparedStatement.executeUpdate();
	}catch(SQLException | ClassNotFoundException e) {
		throw new BusinessException("Internal error occured contact system admin");
		}
		return 200;
	}

	@Override
	public Customer validateSignin(String email, String passWord) throws BusinessException {
		try(Connection connection  = MySqlDbConnection.getConnection()){
			int c;
			String sql = "select newPassword from customer where newEmail= "+ email;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet == null) {
			 throw new BusinessException("Create an account");
			}
			String dbPassword = resultSet.getString("newPassword");
		//	System.out.println(dbPassword);
			if(passWord.equals(dbPassword)) {
				String sql1 = "select cusid,name,newEmail  from customer where newEmail= "+ email;
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
				ResultSet resultSet1=preparedStatement1.executeQuery();
				Customer customer = new Customer();
				customer.setCusId(resultSet.getInt("cusid"));
				customer.setNewName(resultSet.getString("name"));
				customer.setNewPhnumber(resultSet.getInt("newEmail"));
				return customer;
			}else throw new BusinessException("Incorrect password");
			
			
		}catch(SQLException | ClassNotFoundException e) {
			throw new BusinessException("Internal error occured contact system admin");
			}
	}

}
