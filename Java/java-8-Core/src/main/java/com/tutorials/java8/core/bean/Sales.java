/**
 * 
 */
package com.tutorials.java8.core.bean;

import com.tutorials.java8.core.abstractservices.MonthByMonthQuantity;
import com.tutorials.java8.core.bean.intf.FunctionOverTime;
import com.tutorials.java8.core.bean.intf.QuantityOfInterest;

/**
 * @author Siddhant sahu
 *
 */
public class Sales implements QuantityOfInterest {
	private FunctionOverTime valueFunction;

	public Sales(FunctionOverTime functionOverTime) {
		this.valueFunction = functionOverTime;
	}

	@Override
	public String getName() {
		return "Expected Sales.";
	}

	@Override
	public double valueAt(int time) {
		return this.valueFunction.valueAt(time);
	}
}
