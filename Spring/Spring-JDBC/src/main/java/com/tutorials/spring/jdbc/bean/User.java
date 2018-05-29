/**
 * 
 */
package com.tutorials.spring.jdbc.bean;

import org.springframework.stereotype.Component;

/**
 * @author Siddhant sahu
 *
 */
@Component
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName, int age, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", address=" + address + "]";
	}

}
