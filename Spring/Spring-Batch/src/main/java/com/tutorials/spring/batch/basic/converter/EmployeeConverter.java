/**
 * 
 */
package com.tutorials.spring.batch.basic.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.tutorials.spring.batch.basic.bean.Employee;
import com.tutorials.spring.batch.basic.bean.model.EmployeeModel;

/**
 * @author Siddhant sahu
 *
 */
@Component
public class EmployeeConverter implements Converter {
	private final static Logger LOGGER = Logger.getLogger(EmployeeConverter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.xstream.converters.ConverterMatcher#canConvert(java.lang.
	 * Class)
	 */
	@Override
	public boolean canConvert(Class type) {
		return type.equals(EmployeeModel.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object,
	 * com.thoughtworks.xstream.io.HierarchicalStreamWriter,
	 * com.thoughtworks.xstream.converters.MarshallingContext)
	 */
	@Override
	public void marshal(Object object, HierarchicalStreamWriter streamWriter, MarshallingContext marshallingContext) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.
	 * xstream.io.HierarchicalStreamReader,
	 * com.thoughtworks.xstream.converters.UnmarshallingContext)
	 */
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		EmployeeModel employee = new EmployeeModel();

		// get attribute
		LOGGER.info("unmarshal :==> " + Integer.valueOf(reader.getAttribute("empId")));
		employee.setEmpId(Integer.valueOf(reader.getAttribute("empId")));
		reader.moveDown();

		String firstName = reader.getValue();
		employee.setFirstName(firstName);
		reader.moveUp();

		reader.moveDown();
		String middleName = reader.getValue();
		employee.setMiddleName(middleName);
		reader.moveUp();

		reader.moveDown();
		String lastName = reader.getValue();
		employee.setLastName(lastName);
		reader.moveUp();

		reader.moveDown();
		Date dob = null;
		try {
			dob = new SimpleDateFormat("dd/MM/yyyy").parse(reader.getValue());
		} catch (ParseException e) {
			LOGGER.error(e);
		}
		employee.setDob(dob);
		reader.moveUp();

		reader.moveDown();
		String empEmail = reader.getValue();
		employee.setEmpEmail(empEmail);
		reader.moveUp();

		reader.moveDown();
		String empPhone = reader.getValue();
		employee.setEmpPhone(empPhone);
		reader.moveUp();

		LOGGER.info(":==> " + employee);
		return employee;
	}

}
