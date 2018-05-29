/**
 * 
 */
package com.tutorials.java6.core.bean;

import com.tutorials.java6.core.abstractservices.PolynomialQuantity;

/**
 * @author Siddhant sahu
 *
 */
public class FixedCosts extends PolynomialQuantity {

	public FixedCosts(double constant) {
		super(new double[] { constant });
	}

	public String getName() {
		return "Fixed Cost";
	}

}
