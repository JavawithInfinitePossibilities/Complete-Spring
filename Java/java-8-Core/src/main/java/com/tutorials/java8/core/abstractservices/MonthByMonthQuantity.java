/**
 * 
 */
package com.tutorials.java8.core.abstractservices;

import com.tutorials.java8.core.bean.intf.QuantityOfInterest;

/**
 * @author Siddhant sahu
 *
 */
public abstract class MonthByMonthQuantity implements QuantityOfInterest {

	private final double[] values;

	public MonthByMonthQuantity(double[] values) {
		super();
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see com.tutorials.java8.core.bean.intf.QuantityOfInterest#valueAt(int)
	 */
	public double valueAt(int time) {
		return values[time];
	}

}
