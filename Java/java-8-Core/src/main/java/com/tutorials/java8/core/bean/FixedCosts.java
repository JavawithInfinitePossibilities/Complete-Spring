/**
 * 
 */
package com.tutorials.java8.core.bean;

import com.tutorials.java8.core.bean.intf.FunctionOverTime;
import com.tutorials.java8.core.bean.intf.QuantityOfInterest;

/**
 * @author Siddhant sahu
 *
 */
public class FixedCosts implements QuantityOfInterest {

	private FunctionOverTime valueFunction;

	public FixedCosts(FunctionOverTime functionOverTime) {
		this.valueFunction = functionOverTime;
	}

	public String getName() {
		return "Fixed Cost";
	}

	@Override
	public double valueAt(int time) {
		return this.valueFunction.valueAt(time);
	}

}
