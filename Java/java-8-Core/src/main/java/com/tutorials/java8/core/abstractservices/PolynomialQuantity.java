/**
 * 
 */
package com.tutorials.java8.core.abstractservices;

import com.tutorials.java8.core.bean.intf.QuantityOfInterest;

/**
 * @author Siddhant sahu
 *
 */
public abstract class PolynomialQuantity implements QuantityOfInterest {

	private final double[] values;

	public PolynomialQuantity(double[] values) {
		super();
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see com.tutorials.java8.core.bean.intf.QuantityOfInterest#valueAt(int)
	 */
	public double valueAt(int time) {
		double value = 0.0;
		for (int i = 0; i < values.length; i++) {
			value += (values[i] * Math.pow(time, i));
		}
		return value;
	}

}
