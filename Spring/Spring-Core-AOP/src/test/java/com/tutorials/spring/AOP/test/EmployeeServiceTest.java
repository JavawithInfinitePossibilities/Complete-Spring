/**
 * 
 */
package com.tutorials.spring.AOP.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.spring.AOP.bean.Employee;
import com.tutorials.spring.AOP.services.EmployeeServices;

/**
 * @author Siddhant sahu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/Spring-AOP-Config.xml")
public class EmployeeServiceTest {

	@Autowired
	private ApplicationContext context;

	@Before
	public void init() {
		Employee employee = new Employee(1, "Sidhanth", "Sahu", 30, 30000, "Bangalore");
		Employee employee1 = new Employee(2, "Chunmun", "Sahu", 27, 30000, "Bangalore");
		Employee employee2 = new Employee(3, "Atul", "Panigrahi", 27, 30000, "Bangalore");
		EmployeeServices services = context.getBean("employeeServices", EmployeeServices.class);
		services.addEmployeeService(employee);
		services.addEmployeeService(employee1);
		services.addEmployeeService(employee2);
	}

	@Test
	public void getAllEmployee() {
		EmployeeServices services = context.getBean("employeeServices", EmployeeServices.class);
		List<Employee> employees = services.getAllEmployeeService();
		System.out.println(employees);
	}

	@Ignore
	public void getEmployeeById() {
		EmployeeServices services = context.getBean("employeeServices", EmployeeServices.class);
		Employee employees = services.getEmployeeByIdService(5);
		System.out.println(employees);
	}
}
