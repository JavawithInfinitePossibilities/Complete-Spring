/**
 * 
 */
package com.tutorials.java6.core.bean;

import com.tutorials.java6.core.abstractservices.PolynomialQuantity;

/**
 * @author Siddhant sahu
 *
 */
public class IncrementalCost extends PolynomialQuantity {

	public IncrementalCost(final double intercept, final double slope) {
		super(new double[] { intercept, slope });
	}

	public String getName() {
		return "Incremental Cost";
	}

}
