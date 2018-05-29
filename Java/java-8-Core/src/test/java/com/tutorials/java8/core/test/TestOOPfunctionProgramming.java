/**
 * 
 */
package com.tutorials.java8.core.test;

import com.tutorials.java8.core.bean.FixedCosts;
import com.tutorials.java8.core.bean.IncrementalCost;
import com.tutorials.java8.core.bean.Sales;
import com.tutorials.java8.core.bean.intf.FunctionOverTime;
import com.tutorials.java8.core.services.ProjectedProfit;

/**
 * @author Siddhant sahu
 *
 */
public class TestOOPfunctionProgramming {
	final static double[] EXPECTED_SALES_JAN_TO_DEC = { 42.0, 45.0, 43.5, 48.6, 47.5, 58.9, 23.7,
			54.25, 54.25, 89.7, 97.4, 87.54 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Sales sales = new Sales(FunctionOverTime.monthByMonth(EXPECTED_SALES_JAN_TO_DEC));

		final FixedCosts fixedCosts = new FixedCosts(FunctionOverTime.constant(15.0));
		final IncrementalCost incrementalCost = new IncrementalCost(
				FunctionOverTime.line(5.1, 0.15));

		final ProjectedProfit profit = new ProjectedProfit(sales, incrementalCost, fixedCosts);

		double total = 0.0;
		for (int i = 0; i < 12; i++) {
			total += profit.valueAt(i);
		}

		System.out.println("Total profit for the year: " + total);
	}

}
