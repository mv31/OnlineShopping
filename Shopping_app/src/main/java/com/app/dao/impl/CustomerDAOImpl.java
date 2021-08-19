package com.app.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
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

}