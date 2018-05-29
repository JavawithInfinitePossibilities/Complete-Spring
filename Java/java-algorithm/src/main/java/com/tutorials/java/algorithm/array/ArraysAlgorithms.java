/**
 * 
 */
package com.tutorials.java.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class ArraysAlgorithms {

	public int countSubArraysProudctLessThanK(int[] arr, int k) {
		int start = 0;
		int end = 1;
		long product = arr[0];
		int count = 0;
		while (start <= end && end <= arr.length) {
			if (product < k) {
				count += end - start;
				if (end < arr.length)
					product *= arr[end];
				end++;
			} else {
				product /= arr[start++];
			}
		}
		return count;
	}

	@Ignore
	public void testCountSubArraysProudctLessThanK() {
		int[] nums = { 10, 4, 2, 6 };
		int k = 100;
		System.out.println(countSubArraysProudctLessThanK(nums, k));
	}

	public void slidingWindow(int[] array, int size) {
		List<Integer> maxValue = new ArrayList<Integer>();
		for (int i = 0; i < (array.length - size); i++) {
			int max = array[i];
			for (int j = 1; j < size; j++) {
				if (max < array[j + i]) {
					max = array[j + i];
				}
			}
			maxValue.add(max);
		}
		System.out.println(maxValue);
	}

	@Ignore
	public void testslidingWindow() {
		int[] nums = { 1, 2, 3, 2, 4, 1, 5, 6, 1 };
		int k = 3;
		slidingWindow(nums, k);
	}

	public static final int tergetSum = 25;
	public Stack<Integer> stackValue = new Stack<>();
	public int sumInStack = 0;
	public Set<List<Integer>> unique = new HashSet<>();

	public void coinChange(int[] values, int startIndex) {
		if (sumInStack == tergetSum) {
			System.out.println(stackValue);
			List<Integer> list = new ArrayList<>(stackValue);
			unique.add(list);
		} else {
			for (int currentIndex = startIndex; currentIndex < values.length; currentIndex++) {
				if (sumInStack + values[currentIndex] <= tergetSum) {
					stackValue.push(values[currentIndex]);
					sumInStack += values[currentIndex];
					coinChange(values, currentIndex);
					sumInStack -= stackValue.pop();
				}
			}
		}
	}

	@Ignore
	public void testCoinChange() {
		int[] values = { 5, 12, 8, 15, 6, 4, 11, 8, 5 };
		coinChange(values, 0);
		System.out.println("Unique :" + unique.size());
	}

	public void printAllSubSequences(int[] array) {
		int[] temp = new int[array.length];
		int index = 0;
		solve(array, temp, index);
	}

	private void solve(int[] array, int[] temp, int index) {
		if (index == array.length) {
			print(array, temp);
			return;
		}
		temp[index] = 1;
		solve(array, temp, index + 1);

		temp[index] = 0;
		solve(array, temp, index + 1);
	}

	private void print(int[] array, int[] temp) {
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1) {
				result += array[i] + " ";
			}
		}
		if (result == "") {
			result = "{Empty Set}";
		}

		System.out.println(result);
	}

	@Ignore
	public void testPrintAllSubSequences() {
		int[] arrInput = { 1, 2, 3 };
		printAllSubSequences(arrInput);
	}

	public int smallestSumCannotFormInSortedArray1(int[] arr) {
		int smallestSum = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= smallestSum) {
				smallestSum += arr[i];
			} else {
				break;
			}
		}
		return smallestSum;
	}

	@Ignore
	public void testSmallestSumCannotFormInSortedArray() {
		int[] arr = { 1, 1, 3, 4, 6, 7, 9 };
		System.out.println("{ 1,1,3,4,6,7,9}-" + smallestSumCannotFormInSortedArray1(arr));
		int[] arrB = { 1, 1, 1, 1, 1 };
		System.out.println("{1,1,1,1,1} -" + smallestSumCannotFormInSortedArray1(arrB));
		int[] arrC = { 2, 3, 6, 7 };
		System.out.println("{2,3,6,7} -" + smallestSumCannotFormInSortedArray1(arrC));
		int[] arrD = { 1, 2, 6, 7, 9 };
		System.out.println("{1,2,6,7,9} -" + smallestSumCannotFormInSortedArray1(arrD));
	}

	public BSTNode sortedArrayToBSTConversion2(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		BSTNode node = new BSTNode(arr[mid]);
		node.left = sortedArrayToBSTConversion2(arr, start, mid - 1);
		node.right = sortedArrayToBSTConversion2(arr, mid + 1, end);
		return node;
	}

	public void displayBSTree(BSTNode root) {
		if (root != null) {
			displayBSTree(root.left);
			System.out.print(" " + root.data);
			displayBSTree(root.right);
		}
	}

	@Ignore
	public void testSortedArrayToBST() {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		BSTNode root = sortedArrayToBSTConversion2(arr, 0, arr.length - 1);
		displayBSTree(root);
	}

	public int countAllPathDynm3(int[][] arr) {
		int[][] tmpArr = new int[arr.length][arr[0].length];
		for (int i = 0; i < tmpArr.length; i++) {
			tmpArr[i][0] = 1;
		}
		for (int i = 0; i < tmpArr[0].length; i++) {
			tmpArr[0][i] = 1;
		}
		for (int i = 1; i < tmpArr.length; i++) {
			for (int j = 1; j < tmpArr[0].length; j++) {
				tmpArr[i][j] = tmpArr[i][j - 1] + tmpArr[i - 1][j] + tmpArr[i - 1][j - 1];
			}
		}
		return tmpArr[arr.length - 1][arr[0].length - 1];
	}

	@Ignore
	public void testCountAllPathDynm3() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("No of Paths By Recursion: " + countAllPathDynm3(arr));
	}

	public void printAllPathIn2DArray4(int[][] arr, int currRowCount, int currColumnCount,
			String path) {
		int rowCount = arr.length - 1;
		int columnCount = arr[0].length - 1;
		if (currRowCount == rowCount) {
			for (int i = currColumnCount; i <= columnCount; i++) {
				path += "-" + arr[currRowCount][i];
			}
		}

		if (currColumnCount == columnCount) {
			for (int i = currRowCount; i <= rowCount; i++) {
				path += "-" + arr[i][currColumnCount];
			}
		}

		if (currRowCount == rowCount) {
			System.out.println(path);
			return;
		}
		if (currColumnCount == columnCount) {
			System.out.println(path);
			return;
		}
		path += "-" + arr[currRowCount][currColumnCount];
		printAllPathIn2DArray4(arr, currRowCount + 1, currColumnCount, path);
		printAllPathIn2DArray4(arr, currRowCount, currColumnCount + 1, path);
	}

	@Ignore
	public void testPrintAllPathIn2DArray() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printAllPathIn2DArray4(arr, 0, 0, "");
	}

	public void rearrangePoseNegNum5(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		rearrangePoseNegNum5(arr, low, mid);
		rearrangePoseNegNum5(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	private void merge(int[] arr, int low, int mid, int high) {
		int start = low;
		int end = mid + 1;
		while (start <= mid && arr[start] <= 0) {
			start++;
		}
		while (end <= high && arr[end] <= 0) {
			end++;
		}
		reverse(arr, start, mid);
		reverse(arr, mid + 1, end - 1);
		reverse(arr, start, end - 1);
	}

	private void reverse(int[] arr, int start, int mid) {
		while (start < mid) {
			swap(arr, start, mid);
			start++;
			mid--;
		}
	}

	@Ignore
	public void testRearrangePoseNegNum() {
		int[] arr = { 1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20 };
		rearrangePoseNegNum5(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public String longestPrefixSequence6(String[] arr) {
		int resultLen = arr[0].length();
		int curr;
		for (int i = 1; i < arr.length; i++) {
			curr = 0;
			while (curr < resultLen && curr < arr[i].length()
					&& arr[0].charAt(curr) == arr[i].charAt(curr)) {
				curr++;
			}
			resultLen = curr;
		}
		return arr[0].substring(0, resultLen);
	}

	@Ignore
	public void testLongestPrefixSequence() {
		String x = "Sumit Summation Summit Sum";
		String[] arr = x.split(" ");
		System.out.println(longestPrefixSequence6(arr));
	}

	public void print2DArrayInSpiral7(int[][] arr, int rowStart, int rowEnd, int columnStart,
			int columnEnd, boolean reverse, boolean rowPoint) {
		if (rowStart > rowEnd && columnStart > columnEnd) {
			return;
		}
		if (rowPoint == false) {
			if (reverse == false) {
				for (int i = columnStart; i <= columnEnd; i++) {
					System.out.print(" " + arr[rowStart][i]);
				}
			}
			rowStart++;
			rowPoint = true;
			reverse = false;
		}
		if (rowPoint == true) {
			if (reverse == false) {
				for (int i = rowStart; i <= rowEnd; i++) {
					System.out.print(" " + arr[i][columnEnd]);
				}
			}
			columnEnd--;
			rowPoint = false;
			reverse = true;
		}
		if (rowPoint == false) {
			if (reverse == true) {
				for (int i = columnEnd; i >= columnStart; i--) {
					System.out.print(" " + arr[rowEnd][i]);
				}
			}
			rowEnd--;
			rowPoint = true;
			reverse = true;
		}
		if (rowPoint == true) {
			if (reverse == true) {
				for (int i = rowEnd; i >= rowStart; i--) {
					System.out.print(" " + arr[i][columnStart]);
				}
			}
			columnStart++;
			rowPoint = false;
			reverse = false;
		}
		print2DArrayInSpiral7(arr, rowStart, rowEnd, columnStart, columnEnd, reverse, rowPoint);
		return;
	}

	@Ignore
	public void testPrint2DArrayInSpiral() {
		int arr[][] = { { 1, 2, 3, 4, 5 }, { 18, 19, 20, 21, 6 }, { 17, 28, 29, 22, 7 },
				{ 16, 27, 30, 23, 8 }, { 15, 26, 25, 24, 9 }, { 14, 13, 12, 11, 10 } };
		print2DArrayInSpiral7(arr, 0, 5, 0, 4, false, false);
		System.out.println();
		int[][] arrA = { { 2, 3, 1, 6 }, { 12, 13, 5, 7 }, { 8, 4, 11, 9 } };
		print2DArrayInSpiral7(arrA, 0, 2, 0, 3, false, false);
	}

	public void twoNumbersInArraySumEqToK8(int[] arr, int value) {
		int start = 0;
		int end = arr.length - 1;
		Arrays.sort(arr);
		while (start != end && start < end) {
			int sum = arr[start] + arr[end];
			if (sum == value) {
				System.out.println("My two value is :" + arr[start] + ":" + arr[end]);
				return;
			} else if (sum > value) {
				end--;
			} else if (sum < value) {
				start++;
			}
		}
	}

	@Ignore
	public void testTwoNumbersInArraySumEqToK() {
		int arr[] = { 1, 2, 3, 4, 5, 16, 17, 18, 19, 249 };
		int value = 8;
		twoNumbersInArraySumEqToK8(arr, value);
	}

	public void findElementInSorted2DArray9(int[][] arr, int value) {
		int row = 0;
		int column = arr[0].length - 1;
		while (true) {
			if (value == arr[row][column]) {
				System.out.println("The index are :" + row + ":" + column);
				return;
			} else if (value > arr[row][column]) {
				row++;
			} else if (value < arr[row][column]) {
				column--;
			}
			if (row >= arr.length || column < 0) {
				System.out.println("Value not available.");
				return;
			}
		}
	}

	@Ignore
	public void testFindElementInSorted2DArray() {
		int[][] arr = { { 1, 2, 3, 4 }, { 6, 7, 8, 9 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 },
				{ 22, 23, 24, 26 } };
		int value = 5;
		findElementInSorted2DArray9(arr, value);
	}

	public boolean isPalindrome10(String value) {
		if (value.length() < 2) {
			return true;
		}
		if (value.charAt(0) == value.charAt(value.length() - 1)) {
			return isPalindrome10(value.substring(1, value.length() - 1));
		} else {
			return false;
		}
	}

	@Ignore
	public void testIsPalindrome() {
		String S3 = "ABCDEFGHGFEDCBA";
		System.out.println("Is " + S3 + " Palindrome ??? :" + isPalindrome10(S3));
	}

	public int peakElement11(int[] arr, int start, int end, int size) {
		int mid = (start + end) / 2;
		if ((mid == 0 || arr[mid] >= arr[mid - 1])
				&& (arr[mid] >= arr[mid + 1] || mid == size - 1)) {
			return mid;
		} else if (mid > 0 && arr[mid] < arr[mid - 1]) {
			return peakElement11(arr, start, mid - 1, size);
		} else {
			return peakElement11(arr, mid + 1, end, size);
		}
	}

	@Ignore
	public void testPeakElement() {
		int arr[] = { 1, 2, 3, 4, 0, 1, 5, 4, 3, 2, 1 };
		int peakEle = peakElement11(arr, 0, arr.length - 1, arr.length);
		System.out.println("Peak Element is found at index [" + peakEle + "] = " + arr[peakEle]);
	}

	public int[] findTwoMissingNumbers12(int[] arr, int rang) {
		int actualSum = 0;
		int prod = 1;
		int prodN = 1;

		int sumOfNNo = (rang * (rang + 1)) / 2;
		for (int i = 0; i < arr.length; i++) {
			actualSum += arr[i];
		}

		int diff = sumOfNNo - actualSum;/*diff=(a+b)*/

		for (int i = 0; i < arr.length; i++) {
			prod *= arr[i];
		}
		for (int i = 1; i <= rang; i++) {
			prodN *= i;
		}

		int product = prodN / prod;

		int diffSqur = (int) Math.sqrt((diff * diff) - (4 * product));
		int valueA = (diff + diffSqur) / 2;
		int valueB = diff - valueA;
		int[] values = { valueA, valueB };
		return values;
	}

	@Ignore
	public void testFindTwoMissingNumbers() {
		int[] arrA = { 10, 2, 3, 5, 7, 8, 9, 1 };
		System.out.println(
				"Missing numbers are :" + Arrays.toString(findTwoMissingNumbers12(arrA, 10)));
	}

	public void subarrayProductLessThanK13(int[] array, int value) {
		Set<Stack<Integer>> stacks = new LinkedHashSet<>();
		for (int startPoint = 0; startPoint < array.length; startPoint++) {
			for (int grp = startPoint; grp <= array.length; grp++) {
				Stack<Integer> stack = new Stack<>();
				int product = 1;
				for (int index = startPoint; index < grp; index++) {
					product *= array[index];
					stack.push(array[index]);
				}
				if (product <= value && !stack.isEmpty()) {
					stacks.add(stack);
				}
			}
		}
		System.out.println(stacks);
	}

	@Ignore
	public void testSubarrayProductLessThanK() {
		int[] nums = { 10, 4, 2, 6 };
		int k = 100;
		subarrayProductLessThanK13(nums, k);
	}

	public void printSubArrays14(int[] arrA) {
		Set<Stack<Integer>> stacks = new LinkedHashSet<>();
		int arrSize = arrA.length;
		for (int startPoint = 0; startPoint < arrSize; startPoint++) {
			for (int grps = startPoint; grps <= arrSize; grps++) {
				Stack<Integer> stack = new Stack<>();
				for (int j = startPoint; j < grps; j++) {
					System.out.print(arrA[j] + " ");
					stack.push(arrA[j]);
				}
				stacks.add(stack);
				System.out.println();
			}
		}
		System.out.println(stacks);
	}

	@Ignore
	public void testPrintSubArrays() {
		int[] arrA = { 1, 2, 3, 4 };
		printSubArrays14(arrA);
	}

	public int subArraySumFormula15(int[] arr) {
		int length = arr.length;
		int totalSum = 0;

		for (int i = 0; i < length; i++) {
			totalSum += arr[i] * (length - i) * (i + 1);
		}
		return totalSum;
	}

	@Ignore
	public void testSubArraySumFormula15() {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println("Sum of elements of sub arrays is: " + subArraySumFormula15(arr));
	}

	public int subArraySum16(int[] arr) {
		int totalSum = 0;
		for (int startPoint = 0; startPoint < arr.length; startPoint++) {
			for (int grp = startPoint; grp <= arr.length; grp++) {
				for (int index = startPoint; index < grp; index++) {
					totalSum += arr[index];
				}
			}
		}
		return totalSum;
	}

	@Ignore
	public void testSubArraySum16() {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println("Sum of elements of sub arrays is: " + subArraySum16(arr));
	}

	public Set<Stack<Integer>> printAllSubArrays17(int[] arr) {
		Set<Stack<Integer>> stacks = new HashSet<>();
		for (int startPoint = 0; startPoint < arr.length; startPoint++) {
			for (int grp = 0; grp <= arr.length; grp++) {
				Stack<Integer> stack = new Stack<>();
				for (int index = startPoint; index < grp; index++) {
					stack.push(arr[index]);
				}
				stacks.add(stack);
			}
		}
		return stacks;
	}

	@Ignore
	public void testprintAllSubArrays17() {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println("Sub arrays are: " + printAllSubArrays17(arr));
	}

	public char[] printDuplicatChar18(String value) {
		char[] charArr = value.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < charArr.length; i++) {
			if (charMap.containsKey(charArr[i])) {
				charMap.put(charArr[i], charMap.get(charArr[i]) + 1);
			} else {
				charMap.put(charArr[i], 1);
			}
		}
		int size = charMap.keySet().size();
		char[] values = new char[size];
		int index = 0;
		Set<Character> characters = charMap.keySet();
		for (Character character : characters) {
			if (charMap.get(character) > 1) {
				values[index++] = character;
			}
		}
		return values;
	}

	@Ignore
	public void testPrintDuplicatChar18() {
		String value = "madam";
		System.out.println(Arrays.toString(printDuplicatChar18(value)));
	}

	public int[] oddAndEvenSeparate19(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] % 2 == 0) {
				start++;
			} else if (arr[end] % 2 == 1) {
				end--;
			} else {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return arr;
	}

	@Ignore
	public void testOddAndEvenSeparate19() {
		int[] arr = { 1, 2, 3, 4, 6, 8, 7, 12 };
		arr = oddAndEvenSeparate19(arr);
		System.out.println(Arrays.toString(arr));
	}

	public int[] nVeAndpVeSeparate20(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			if (arr[start] > 0) {
				start++;
			} else if (arr[end] < 0) {
				end--;
			} else {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return arr;
	}

	@Ignore
	public void testnVeAndpVeSeparate20() {
		int[] arr = { 1, -1, 1, -1, -1 };
		arr = nVeAndpVeSeparate20(arr);
		System.out.println(Arrays.toString(arr));
	}

	public int[] threeNumbersSumKSorting21(int[] arr, int value) {
		Arrays.sort(arr);
		int[] result = new int[3];
		for (int i = 0; i < arr.length; i++) {
			int first = arr[i];
			int start = i + 1;
			int end = arr.length - 1;
			int diff = value - first;
			while (start < end) {
				int sum = arr[start] + arr[end];
				if (sum == diff) {
					System.out.println("Found 3 elements whose sum is = " + value);
					System.out
							.println("Elements are " + arr[i] + " " + arr[start] + " " + arr[end]);
					result[0] = arr[i];
					result[1] = arr[start];
					result[2] = arr[end];
					return result;
				} else if (sum < diff) {
					start++;
				} else {// sum>diff
					end--;
				}
			}
		}
		return result;
	}

	@Ignore
	public void testThreeNumbersSumKSorting21() {
		int arr[] = { 3, 1, 7, 4, 5, 9, 10 };
		int k = 21;
		arr = threeNumbersSumKSorting21(arr, k);
		System.out.println(Arrays.toString(arr));
	}

	public void majorityElementHashing22(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int result = 0;
		boolean flag = false;
		Iterator<Entry<Integer, Integer>> set = map.entrySet().iterator();
		while (set.hasNext()) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) set.next();
			if (entry.getValue() >= arr.length / 2) {
				result = entry.getKey();
				flag = true;
			}
		}
		if (flag) {
			System.out.println("(Hashing)Element appearing more than n/2 times: " + result);
		} else {
			System.out.println("No element appearing more than n/2 times");
		}
	}

	@Ignore
	public void testMajorityElementHashing22() {
		int[] arr = { 1, 3, 5, 5, 5, 5, 4, 1, 5 };
		majorityElementHashing22(arr);
	}

	public int localMinimaBinary23(int[] arr, int start, int end) {
		int mid = start + (end - start) / 2;
		int size = arr.length;
		if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == size - 1 || arr[mid + 1] > arr[mid])) {
			return arr[mid];
		} else if (mid > 0 && arr[mid - 1] < arr[mid]) {
			return localMinimaBinary23(arr, start, mid - 1);
		} else {// mid > 0 && arr[mid + 1] < arr[mid]
			return localMinimaBinary23(arr, mid + 1, end);
		}
	}

	@Ignore
	public void testLocalMinimaBinary23() {
		int[] arr = { 11, 4, 2, 5, 11, 13, 5 };
		System.out.println("Local Minima is: " + localMinimaBinary23(arr, 0, arr.length));
	}

	public boolean isSortedUsingRecursion24(int[] arr, int start) {
		if (start == arr.length - 1) {
			return true;
		}
		if (arr[start] <= arr[start + 1]) {
			return isSortedUsingRecursion24(arr, start + 1);
		} else {
			return false;
		}
	}

	@Ignore
	public void testIsSortedUsingRecursion() {
		int[] arr = { 1, 2, 3, 4, 8, 8, 22, 50 };
		System.out.println(isSortedUsingRecursion24(arr, 0));
	}

	public int firstIndexOfZeroBinarySearch25(int[] arr, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			if (arr[start] == 0) {
				return start;
			}
			if (arr[start] == 1) {
				return -1;
			}
		}

		int mid = start + (end - start) / 2;
		if (arr[mid] == 0 && arr[mid - 1] == 1) {
			return mid;
		} else if (arr[mid] == 0 && arr[mid - 1] == 0) {
			return firstIndexOfZeroBinarySearch25(arr, start, mid - 1);
		} else {// arr[mid]==1
			return firstIndexOfZeroBinarySearch25(arr, mid + 1, end);
		}
	}

	@Ignore
	public void testFirstIndexOfZeroBinarySearch25() {
		int[] arr = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println("(Binary Search)First Index from where 0 starts: "
				+ firstIndexOfZeroBinarySearch25(arr, 0, arr.length - 1));
	}

	public int firstDecreasingBinarySearch26(int[] arr, int start, int end) {
		if (start == end) {
			return start;
		}
		if (start == end - 1 && arr[start] > arr[end]) {
			return start;
		}
		if (start == end - 1 && arr[start] < arr[end]) {
			return end;
		}

		int mid = start + (end - start) / 2;
		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
			return mid;
		} else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
			return firstDecreasingBinarySearch26(arr, start, mid - 1);
		} else {
			return firstDecreasingBinarySearch26(arr, mid + 1, end);
		}
	}

	@Ignore
	public void testFirstDecreasingBinarySearch26() {
		int[] arr = { 1, 2, 4, 6, 11, 15, 19, 20, 21, 31, 41, 51, 55, 46, 35, 24, 18, 14, 13, 12,
				11, 4, 2, 1 };
		int index = firstDecreasingBinarySearch26(arr, 0, arr.length - 1);
		System.out.println(
				"(Binary Search) First Element from where elements starts decreasing: (index: "
						+ index + ") : " + arr[index]);
	}

	public Entry<Stack<Integer>, Integer> maximumSubArray27(int[] arr) {
		Map<Stack<Integer>, Integer> map = new HashMap<>();
		for (int start = 0; start < arr.length; start++) {
			for (int grp = 0; grp <= arr.length; grp++) {
				Stack<Integer> stack = new Stack<>();
				int sum = 0;
				for (int index = start; index < grp; index++) {
					sum += arr[index];
					stack.push(arr[index]);
				}
				map.put(stack, sum);
			}
		}
		int bigSum = 0;
		Iterator<Entry<Stack<Integer>, Integer>> iterator = map.entrySet().iterator();
		Entry<Stack<Integer>, Integer> result = null;
		while (iterator.hasNext()) {
			Map.Entry<Stack<Integer>, Integer> entry = (Map.Entry<Stack<Integer>, Integer>) iterator
					.next();
			if (entry.getValue() > bigSum) {
				bigSum = entry.getValue();
				result = entry;
			}
		}
		return result;
	}

	@Ignore
	public void testMaximumSubArray27() {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("Maximum Sub Array sum is : " + maximumSubArray27(arr));
	}

	public int sumCloseToZero28(int[] arr) {
		Arrays.sort(arr);
		int posNo = Integer.MAX_VALUE;
		int negNo = Integer.MIN_VALUE;
		int start = 0, end = arr.length - 1;
		while (start < end) {
			int temp = arr[start] + arr[end];
			if (temp > 0) {
				if (temp < posNo) {
					posNo = temp;
					end--;
				}
			} else if (temp < 0) {
				if (negNo < temp) {
					negNo = temp;
				}
				start++;
			} else {
				return 0;
			}
		}

		return Math.min(Math.abs(posNo), Math.abs(negNo));
	}

	@Ignore
	public void testSumCloseToZero28() {
		int arr[] = { 1, 4, -5, 3, -2, 10, -6, 20 };
		int closestSum = sumCloseToZero28(arr);
		System.out.println("Sum close to zero in the given array is : " + closestSum);
	}

	public int noOfPathsPathCount29(int[][] arr) {
		int[][] temp = new int[arr.length][arr[0].length];
		int row = 0;
		int column = 0;
		for (int columnIndex = 0; columnIndex < temp[row].length; columnIndex++) {
			temp[row][columnIndex] = 1;
		}
		for (int rowIndex = 0; rowIndex < temp.length; rowIndex++) {
			temp[rowIndex][column] = 1;
		}
		for (row = 1; row < temp.length; row++) {
			for (column = 1; column < temp[row].length; column++) {
				temp[row][column] = temp[row - 1][column] + temp[row][column - 1];
			}
		}

		return temp[arr.length - 1][arr.length - 1];
	}

	@Ignore
	public void testnoOfPathsPath29() {
		int arrA[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println("No Of Path (DP):- " + noOfPathsPathCount29(arrA));
	}

	public int editDistanceProblem30(String val1, String val2) {
		int[][] tmp = new int[val1.length() + 1][val2.length() + 1];
		for (int column = 0; column <= val2.length(); column++) {
			tmp[0][column] = column;
		}
		for (int row = 0; row <= val1.length(); row++) {
			tmp[row][0] = row;
		}
		for (int row = 1; row <= val1.length(); row++) {
			for (int column = 1; column <= val2.length(); column++) {
				if (val1.charAt(row - 1) == val2.charAt(column - 1)) {
					tmp[row][column] = tmp[row - 1][column - 1];
				} else {
					tmp[row][column] = 1 + Math.min(tmp[row][column - 1],
							Math.min(tmp[row - 1][column], tmp[row - 1][column - 1]));
				}
			}
		}

		return tmp[val1.length()][val2.length()];
	}

	@Ignore
	public void testEditDistanceProblem30() {
		String s1 = "horizon";
		String s2 = "horizontal";
		System.out.println("Minimum Edit Distance -(DP): " + editDistanceProblem30(s1, s2));
	}

	public void findCommonElement3Arrays31(int[] arrA, int[] arrB, int[] arrC) {
		int i = 0, j = 0, k = 0;
		while (i < arrA.length && j < arrB.length && k < arrC.length) {
			if ((arrA[i] == arrB[j]) && (arrB[j] == arrC[k])) {
				System.out.print(arrA[i] + " ");
				i++;
				j++;
				k++;
			} else if ((arrA[i] <= arrB[j]) && (arrA[i] <= arrC[k])) {
				i++;
			} else if ((arrB[j] <= arrA[i]) && (arrB[j] <= arrC[k])) {
				j++;
			} else {
				k++;
			}
		}
	}

	@Ignore
	public void testFindCommonElement3Arrays31() {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] B = { 1, 3, 5, 6, 7, 8, 12 };
		int[] C = { 2, 3, 4, 5, 8, 9 };
		System.out.print("Common Elements are : ");
		findCommonElement3Arrays31(A, B, C);
	}

	public int[] descendingOddAscendingEven32(int[] arr) {
		separateOddEven(arr, 0, arr.length - 1);
		int index = 0;
		while (arr[index] % 2 != 0) {
			index++;
			if (index == arr.length - 1) {
				break;
			}
		}
		if (index != arr.length - 1) {
			customSort(arr, 0, index - 1);
		} else {
			customSort(arr, 0, index);
		}
		customSort(arr, index, arr.length - 1);
		return arr;
	}

	private void customSort(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int left = start;
		int right = end;
		int pivot = arr[mid];
		while (left <= right) {
			if (arr[left] % 2 == 0) {
				while (arr[left] > pivot) {
					left++;
				}
				while (arr[right] < pivot) {
					right--;
				}
			} else if (arr[left] % 2 != 0) {
				while (arr[left] < pivot) {
					left++;
				}
				while (arr[right] > pivot) {
					right--;
				}
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		if (start < right) {
			customSort(arr, start, right);
		}
		if (left < end) {
			customSort(arr, left, end);
		}
	}

	private void separateOddEven(int[] arr, int start, int end) {
		while (start < end) {
			if (arr[start] % 2 != 0) {
				start++;
			} else if (arr[end] % 2 == 0) {
				end--;
			} else {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
	}

	@Ignore
	public void testDescendingOddAscendingEven32() {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Original Array : ");
		System.out.println(Arrays.toString(arr));
		System.out.println("\nOutput Array : ");
		descendingOddAscendingEven32(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void stringPermutations33(char[] arr, int start, int size) {
		int x;
		if (start == size) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.print(" ");
		} else {
			for (x = start; x < size; x++) {
				swap(arr, start, x);
				stringPermutations33(arr, start + 1, size);
				swap(arr, start, x);
			}
		}
	}

	private void swap(char[] arr, int start, int x) {
		char val = arr[start];
		arr[start] = arr[x];
		arr[x] = val;
	}

	@Ignore
	public void testStringPermutations33() {
		String s = "abc";
		char[] arrCh = s.toCharArray();
		stringPermutations33(arrCh, 0, arrCh.length);
	}

	public int kthSmallestElement34(int[] arr, int kTh) {
		kTh = kTh - 1;
		return findkthSmallestElement(arr, 0, arr.length - 1, kTh);
	}

	private int findkthSmallestElement(int[] arr, int start, int end, int kTh) {
		int left = start;
		int right = end;
		int pivot = start;
		while (left <= right) {
			while (left <= right && arr[left] <= arr[pivot]) {
				left++;
			}
			while (left <= right && arr[right] >= arr[pivot]) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		swap(arr, pivot, right);

		if (pivot == kTh) {
			return arr[pivot];
		} else if (pivot < kTh) {
			return findkthSmallestElement(arr, pivot + 1, end, kTh);
		} else {
			return findkthSmallestElement(arr, start, pivot - 1, kTh);
		}
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	@Ignore
	public void testKthSmallestElement() {
		int[] arrA = { 2, 3, 11, 16, 27, 4, 15, 9, 8 };
		int a = 4;
		int x = kthSmallestElement34(arrA, a);
		System.out.print("The " + a + "th smallest element is : " + x);
	}

	public int intersecionPoint2Arrays35(int[] arrA, int[] arrB) {
		int indexA = 0, indexB = 0, intersection = -1;
		while (indexA < arrA.length && indexB < arrB.length) {
			if (arrA[indexA] > arrB[indexB]) {
				indexB++;
			} else if (arrA[indexA] < arrB[indexB]) {
				indexA++;
			} else {
				intersection = arrA[indexA];
				return intersection;
			}
		}
		return intersection;
	}

	@Ignore
	public void testIntersecionPoint2Arrays35() {
		int[] a = { 1, 2, 3, 6, 8, 10 };
		int[] b = { 4, 5, 6, 11, 15, 20 };
		System.out.println("Intersection point is : " + intersecionPoint2Arrays35(a, b));
	}

	public int[] rearragePostiveNegativeAlternatively36(int[] arr) {
		int start = 0, end = arr.length - 1, high = 0, left = 1, right;
		while (start < end) {
			if (arr[start] < 0) {
				start++;
			} else if (arr[end] > 0) {
				end--;
			} else {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		while (arr[high] < 0) {
			high++;
		}
		right = high;
		while (arr[left] < 0 && right < arr.length) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left += 2;
			right++;
		}
		return arr;
	}

	@Ignore
	public void testrearragePostiveNegativeAlternatively36() {
		int[] arrA = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
		System.out.println("Intersection point is : "
				+ Arrays.toString(rearragePostiveNegativeAlternatively36(arrA)));
	}

	public Stack<Integer> minimumSubArraySum37(int[] arr, int sum) {
		Stack<Integer> stack = new Stack<>();
		for (int start = 0; start < arr.length; start++) {
			for (int grp = start; grp <= arr.length; grp++) {
				Stack<Integer> integers = new Stack<>();
				int tempSum = 0;
				for (int index = start; index < grp; index++) {
					tempSum += arr[index];
					integers.push(arr[index]);
				}
				if (tempSum > sum) {
					if (!stack.isEmpty() && stack.size() > integers.size()) {
						stack = integers;
					} else {
						stack = integers;
					}
				}
			}
		}
		return stack;
	}

	@Ignore
	public void testminimumSubArraySum37() {
		int[] arrA = { 1, 10, 3, 40, 18 };
		System.out.println(minimumSubArraySum37(arrA, 50));
	}

	public boolean checkArrayHasConsecutiveNos38(int[] arr) {
		Arrays.sort(arr);
		int endEle = arr[arr.length - 1];
		int startEle = arr[0];
		int actualTotal = ((endEle * (endEle + 1)) / 2) - ((startEle - 1) * startEle) / 2;
		int arrTotal = 0;
		for (int i = 0; i < arr.length; i++) {
			arrTotal += arr[i];
		}
		boolean result = false;
		if (actualTotal == arrTotal) {
			result = true;
		}
		return result;
	}

	@Ignore
	public void testCheckArrayHasConsecutiveNos38() {
		int[] arrA = { 21, 24, 22, 26, 23, 25 };
		System.out.println(checkArrayHasConsecutiveNos38(arrA));
		int[] arrB = { 11, 10, 12, 14, 13 };
		System.out.println(checkArrayHasConsecutiveNos38(arrB));
		int[] arrC = { 11, 10, 14, 13 };
		System.out.println(checkArrayHasConsecutiveNos38(arrC));
	}

	public int longestCommonSubString39(char[] arrA, char[] arrB) {
		int[][] tempArr = new int[arrA.length][arrB.length];
		for (int col = 0; col < arrB.length; col++) {
			tempArr[0][col] = 0;
		}
		for (int row = 0; row < arrA.length; row++) {
			tempArr[row][0] = 0;
		}
		int result = -1;
		for (int i = 1; i < arrA.length; i++) {
			for (int j = 1; j < arrB.length; j++) {
				if (arrA[i - 1] == arrB[j - 1]) {
					tempArr[i][j] = tempArr[i - 1][j - 1] + 1;
				} else {
					tempArr[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < arrA.length; i++) {
			for (int j = 1; j < arrB.length; j++) {
				if (result < tempArr[i][j]) {
					result = tempArr[i][j];
				}
			}
		}
		return result;
	}

	@Ignore
	public void testLongestCommonSubString39() {
		String A = "tutorialhorizon";
		String B = "dynamictutorialProgramming";
		System.out.println(
				"LCS length : " + longestCommonSubString39(A.toCharArray(), B.toCharArray()));
	}
}

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	public BSTNode(int data) {
		this.data = data;
	}

}