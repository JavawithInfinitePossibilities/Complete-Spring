/**
 * 
 */
package com.tutorials.spring.batch.basic.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.tutorials.spring.batch.basic.bean.model.EmployeeModel;

/**
 * @author Siddhant sahu
 *
 */
public class EmployeeRowMapper implements RowMapper<EmployeeModel> {

	private final static Logger LOGGER = Logger.getLogger(EmployeeRowMapper.class);

	@Override
	public EmployeeModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final EmployeeModel employee = new EmployeeModel();
		employee.setEmpId(resultSet.getInt("empId"));
		employee.setFirstName(resultSet.getNString("firstName"));
		employee.setMiddleName(resultSet.getString("middleName"));
		employee.setLastName(resultSet.getString("lastName"));
		employee.setEmpEmail(resultSet.getString("empEmail"));
		employee.setEmpPhone(resultSet.getString("empPhone"));
		employee.setDob(resultSet.getDate("dob"));
		LOGGER.info(employee);
		return employee;
	}

}
