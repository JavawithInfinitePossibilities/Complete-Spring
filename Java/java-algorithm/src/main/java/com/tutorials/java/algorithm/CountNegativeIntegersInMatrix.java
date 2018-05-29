/**
 * 
 */
package com.tutorials.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siddhant sahu
 *
 */
public class CountNegativeIntegersInMatrix {
	public int solution1(int[][] data) {
		int counter = 0;
		for (int i = 0; i < data.length; i++) {
			counter += bin(data[i]);
			System.out.print(".");
		}
		System.out.println();
		return counter;
	}

	private int bin(int[] data) {
		int min = 0;
		int max = data.length;
		int mid = (max + min) / 2;
		List<Integer> list = new ArrayList<>();

		while (true) {
			if (list.contains(mid)) {
				return data[mid] < 0 ? mid + 1 : mid;
			}

			if (data[mid] < 0) {
				list.add(mid);
				min = mid + 1;
				mid = (max + min) / 2;
			} else if (data[mid] > 0) {
				list.add(mid);
				max = mid - 1;
				mid = (max + min) / 2;
			} else if (data[mid] == 0) {
				return mid;
			}
			System.out.print(".");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] data = new int[][] { { -3, -2, -1, 0, 1, 2, 4, 6, 7, 8 }, { -3, -2, -1, 1 },
				{ -2, 2, 3, 4 }, { 4, 5, 7, 8 } };
		CountNegativeIntegersInMatrix matrix = new CountNegativeIntegersInMatrix();
		System.out.println(matrix.solution1(data));
	}
}
