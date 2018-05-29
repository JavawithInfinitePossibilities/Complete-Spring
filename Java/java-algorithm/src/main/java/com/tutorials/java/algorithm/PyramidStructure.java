/**
 * 
 */
package com.tutorials.java.algorithm;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class PyramidStructure {

	/**
	 * 1 45 789
	 * 
	 * @param metrix
	 */
	public void vertical(int[][] metrix) {
		for (int row = 0; row < metrix.length; row++) {
			for (int column = 0; column <= row; column++) {
				System.out.print(metrix[row][column]);
			}
			System.out.println();
		}
	}

	@Ignore
	public void testVertical() {
		int[][] metrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		vertical(metrix);
	}

	/**
	 * 123 56 9
	 * 
	 * @param metrix
	 */
	public void revVertical(int[][] metrix) {
		int counter = 0;
		for (int row = 0; row < metrix.length; row++) {
			for (int column = 0; column <= counter; column++) {
				System.out.print(" ");
			}
			for (int column = counter; column < metrix[row].length; column++) {
				System.out.print(metrix[row][column]);
			}
			System.out.println();
			counter++;
		}
	}

	@Ignore
	public void testRevVertical() {
		int[][] metrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		revVertical(metrix);
	}

	/**
	 * 3 56 789
	 * 
	 * @param metrix
	 */
	public void invVertical(int[][] metrix) {
		int counter = metrix.length - 1;
		for (int row = 0; row < metrix.length; row++) {
			for (int column = 0; column <= counter; column++) {
				System.out.print(" ");
			}
			for (int column = counter; column < metrix[row].length; column++) {
				System.out.print(metrix[row][column]);
			}
			System.out.println();
			counter--;
		}
	}

	@Ignore
	public void testInvVertical() {
		int[][] metrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		invVertical(metrix);
	}

	/**
	 * 123 45 7
	 * 
	 * @param metrix
	 */
	public void revInvVertical(int[][] metrix) {
		int counter = metrix.length - 1;
		for (int row = 0; row < metrix.length; row++) {
			for (int column = 0; column <= counter; column++) {
				System.out.print(metrix[row][column]);
			}
			for (int column = counter; column < metrix[row].length; column++) {
				System.out.print(" ");
			}
			System.out.println();
			counter--;
		}
	}

	@Test
	public void testRevInvVertical() {
		int[][] metrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		revInvVertical(metrix);
	}
}
