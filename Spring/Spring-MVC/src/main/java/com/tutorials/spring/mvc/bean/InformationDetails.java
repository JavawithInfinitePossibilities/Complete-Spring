/**
 * 
 */
package com.tutorials.spring.mvc.bean;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * @author Siddhant sahu
 *
 */
@Component
public class InformationDetails {

	@NotNull
	private String firstName;
	private String lastName;
	private String gender;
	private String citizen;
	private String state;
	private String district;
	private String description;
	private List<String> likes;
	private List<String> flower;

	public InformationDetails() {
		super();
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}

	public List<String> getFlower() {
		return flower;
	}

	public void setFlower(List<String> flower) {
		this.flower = flower;
	}

	@Override
	public String toString() {
		return "InformationDetails [firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", citizen=" + citizen + ", state=" + state + ", district=" + district
				+ ", description=" + description + ", likes=" + likes + "]";
	}

}
