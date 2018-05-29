/**
 * 
 */
package com.tutorials.java6.core.services;

import com.tutorials.java6.core.bean.FixedCosts;
import com.tutorials.java6.core.bean.IncrementalCost;
import com.tutorials.java6.core.bean.Sales;
import com.tutorials.java6.core.bean.intf.QuantityOfInterest;

/**
 * @author Siddhant sahu
 *
 */
public class ProjectedProfit implements QuantityOfInterest {
	private Sales sales;
	private IncrementalCost incrementalCost;
	private FixedCosts fixedCosts;

	public ProjectedProfit(Sales sales, IncrementalCost incrementalCost, FixedCosts fixedCosts) {
		super();
		this.sales = sales;
		this.incrementalCost = incrementalCost;
		this.fixedCosts = fixedCosts;
	}

	/* (non-Javadoc)
	 * @see com.tutorials.java8.core.bean.intf.QuantityOfInterest#getName()
	 */
	public String getName() {
		return "Profit!!";
	}

	/* (non-Javadoc)
	 * @see com.tutorials.java8.core.bean.intf.QuantityOfInterest#valueAt(int)
	 */
	public double valueAt(int time) {
		return sales.valueAt(time) - (incrementalCost.valueAt(time) + fixedCosts.valueAt(time));
	}

}
