/**
 * 
 */
package com.tutorials.spring.jdbc.DAO.intf;

import java.util.List;

import com.tutorials.spring.jdbc.bean.User;

/**
 * @author Siddhant sahu
 *
 */

public interface IUserDAO {

	List<User> getAllUser();
}
