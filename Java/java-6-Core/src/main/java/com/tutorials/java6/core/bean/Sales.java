/**
 * 
 */
package com.tutorials.java6.core.bean;

import com.tutorials.java6.core.abstractservices.MonthByMonthQuantity;

/**
 * @author Siddhant sahu
 *
 */
public class Sales extends MonthByMonthQuantity {

	public Sales(double[] expectedSalesJanToDec) {
		super(expectedSalesJanToDec);
	}

	public String getName() {
		return "Expected Sales.";
	}

}
