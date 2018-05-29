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
public class IncrementalCost implements QuantityOfInterest {

	private FunctionOverTime valueFunction;

	public IncrementalCost(FunctionOverTime functionOverTime) {
		this.valueFunction = functionOverTime;
	}

	public String getName() {
		return "Incremental Cost";
	}

	@Override
	public double valueAt(int time) {
		return valueFunction.valueAt(time);
	}

}
