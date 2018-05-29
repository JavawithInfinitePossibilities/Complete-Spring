/**
 * 
 */
package com.tutorials.java8.core.test;

import com.tutorials.java8.core.bean.intf.FunctionOverTime;

/**
 * @author Siddhant sahu
 *
 */
public class TestFunctionalProgramming {
	final static double[] EXPECTED_SALES_JAN_TO_DEC = { 42.0, 45.0, 43.5, 48.6, 47.5, 58.9, 23.7,
			54.25, 54.25, 89.7, 97.4, 87.54 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final FunctionOverTime sales = FunctionOverTime.monthByMonth(EXPECTED_SALES_JAN_TO_DEC);

		final FunctionOverTime fixedCosts = FunctionOverTime.constant(15.0);
		final FunctionOverTime incrementalCost = FunctionOverTime.line(5.1, 0.15);

		final FunctionOverTime profit = FunctionOverTime.combinationOf3(sales, incrementalCost,
				fixedCosts, (s, ic, fc) -> s - (ic + fc));

		double total = 0.0;
		for (int i = 0; i < 12; i++) {
			total += profit.valueAt(i);
		}

		System.out.println("Total profit for the year: " + total);
	}

}
