/**
 * 
 */
package com.tutorials.spring.mvc.bean;

import org.springframework.stereotype.Component;

/**
 * @author Siddhant sahu
 *
 */
@Component
public class Exercise {
	private int minutes;

	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return "Exercise [minutes=" + minutes + "]";
	}

}
