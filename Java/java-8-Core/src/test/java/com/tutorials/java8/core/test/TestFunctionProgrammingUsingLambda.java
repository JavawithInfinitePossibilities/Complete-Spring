/**
 * 
 */
package com.tutorials.java8.core.test;

import com.tutorials.java8.core.bean.intf.FunctionOverTime;

/**
 * @author Siddhant sahu
 *
 */
public class TestFunctionProgrammingUsingLambda {
	final static double[] EXPECTED_SALES_JAN_TO_DEC = { 42.0, 45.0, 43.5, 48.6, 47.5, 58.9, 23.7,
			54.25, 54.25, 89.7, 97.4, 87.54 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final FunctionOverTime sales = time -> EXPECTED_SALES_JAN_TO_DEC[time];

		final FunctionOverTime fixedCosts = time -> 15.0;
		final FunctionOverTime incrementalCost = time -> 5.1 + time * 0.15;

		final FunctionOverTime profit = time -> sales.valueAt(time)
				- (incrementalCost.valueAt(time) + fixedCosts.valueAt(time));

		double total = 0.0;
		for (int i = 0; i < 12; i++) {
			total += profit.valueAt(i);
		}

		System.out.println("Total profit for the year: " + total);
	}

}
