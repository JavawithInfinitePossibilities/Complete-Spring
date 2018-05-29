/**
 * 
 */
package com.tutorials.spring.AOP.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorials.spring.AOP.bean.Employee;
import com.tutorials.spring.AOP.repository.EmployeeRepo;

/**
 * @author Siddhant sahu
 *
 */
@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRepo repo;

	public void addEmployeeService(Employee employee) {
		repo.addEmployee(employee);
	}

	public List<Employee> getAllEmployeeService() {
		return repo.getAllEmployee();
	}

	public Employee getEmployeeByIdService(int id) {
		return repo.getEmployeeById(id);
	}

	public void updateEmployeeService(Employee employee) {
		repo.updateEmployee(employee);
	}

	public void deleteEmployeeService(Employee employee) {
		repo.deleteEmployee(employee);
	}
}
