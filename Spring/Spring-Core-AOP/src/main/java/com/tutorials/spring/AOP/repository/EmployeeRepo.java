/**
 * 
 */
package com.tutorials.spring.AOP.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorials.spring.AOP.bean.Employee;

/**
 * @author Siddhant sahu
 *
 */
@Repository
public class EmployeeRepo {
	private List<Employee> employees = new LinkedList<Employee>();

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public List<Employee> getAllEmployee() {
		return this.employees;
	}

	public Employee getEmployeeById(int id) {
		return this.employees.get(id - 1);
	}

	public void updateEmployee(Employee employee) {
		Employee emp = getEmployeeById(employee.getId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setAge(employee.getAge());
		emp.setAddress(employee.getAddress());
		emp.setSalary(employee.getSalary());
	}

	public void deleteEmployee(Employee employee) {
		Employee emp = getEmployeeById(employee.getId());
		this.employees.remove(emp);
	}
}
