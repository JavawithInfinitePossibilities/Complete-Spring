/**
 * 
 */
package com.tutorials.spring.jdbc.DAO.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.util.ResultSetUtil;
import com.tutorials.spring.jdbc.DAO.intf.IUserDAO;
import com.tutorials.spring.jdbc.bean.User;

/**
 * @author Siddhant sahu
 *
 */
@Repository
public class UserRepo implements IUserDAO {

	@Autowired
	public DataSource dataSource;

	/* (non-Javadoc)
	 * @see com.tutorials.spring.jdbc.DAO.intf.IUserDAO#getAllUser()
	 */
	public List<User> getAllUser() {
		String getAllUser = "Select * from user";
		List<User> users = new ArrayList<User>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(getAllUser);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("user_id"), resultSet.getString("firstName"),
						resultSet.getString("lastName"), resultSet.getInt("age"),
						resultSet.getString("address"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				resultSet.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
