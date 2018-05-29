/**
 * 
 */
package com.tutorials.java8.core.bean.intf;

/**
 * @author Siddhant sahu
 *
 */
@FunctionalInterface
public interface FunctionOverTime {
	double valueAt(int time);

	static FunctionOverTime monthByMonth(final double[] values) {
		return time -> values[time];
	}

	/*static FunctionOverTime constant(final double value) {
		return time -> value;
	}*/

	static FunctionOverTime constant(final double value) {
		return polynomial(new double[] { value });
	}

	/*static FunctionOverTime line(final double intercept, final double slope) {
		return time -> intercept + time * slope;
	}*/

	static FunctionOverTime line(final double intercept, final double slope) {
		return polynomial(new double[] { intercept, slope });
	}

	static FunctionOverTime polynomial(final double[] values) {
		return time -> {
			double value = 0.0;
			for (int i = 0; i < values.length; i++) {
				value += (values[i] * Math.pow(time, i));
			}
			return value;
		};
	}

	@FunctionalInterface
	static interface FunctionOf3 {
		double apply(double sales, double incrementalCost, double fixedCost);
	}

	static FunctionOverTime combinationOf3(final FunctionOverTime sales,
			final FunctionOverTime incrementalCost, final FunctionOverTime fixedCost,
			final FunctionOf3 f) {
		return time -> f.apply(sales.valueAt(time), incrementalCost.valueAt(time),
				fixedCost.valueAt(time));
	}
}
