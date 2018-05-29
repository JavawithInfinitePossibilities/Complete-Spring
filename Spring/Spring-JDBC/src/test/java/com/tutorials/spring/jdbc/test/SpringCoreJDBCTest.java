/**
 * 
 */
package com.tutorials.spring.jdbc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.spring.jdbc.DAO.repository.UserRepo;
import com.tutorials.spring.jdbc.bean.User;

/**
 * @author Siddhant sahu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/Spring-Application-Config.xml")
public class SpringCoreJDBCTest {

	@Autowired
	private ApplicationContext context;

	@Test
	public void getAllUsers() {
		UserRepo userRepo = context.getBean("userRepo", UserRepo.class);
		List<User> users = userRepo.getAllUser();
		System.out.println(users);
	}
}
