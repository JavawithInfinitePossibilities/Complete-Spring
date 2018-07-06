/**
 * 
 */
package com.tutorials.spring.batch.basic.processor;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.tutorials.spring.batch.basic.bean.Employee;

/**
 * @author Siddhant sahu
 *
 */
@Component("itemProcessor")
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {
	private final static Logger LOGGER = Logger.getLogger(EmployeeItemProcessor.class);

	@Override
	public Employee process(Employee employee) throws Exception {
		LOGGER.info("EmployeeItemProcessor..." + employee);
		return employee;
	}

}
