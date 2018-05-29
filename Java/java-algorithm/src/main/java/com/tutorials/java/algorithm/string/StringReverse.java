/**
 * 
 */
package com.tutorials.java.algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class StringReverse {

	public String reverseIterative(char[] value, int start, int end) {
		while (start <= end) {
			char temp = value[start];
			value[start] = value[end];
			value[end] = temp;
			start++;
			end--;
		}
		return String.copyValueOf(value);
	}

	public void reverseRecursive(char[] value, int start, int end) {
		if (start >= end) {
			return;
		}
		char temp = value[start];
		value[start] = value[end];
		value[end] = temp;
		reverseRecursive(value, ++start, --end);
	}

	@Test
	public void testReverseIterative() {
		String value = "siddhant";
		String reverseString = reverseIterative(value.toCharArray(), 0, value.length() - 1);
		System.out.println(value);
		System.out.println(reverseString);
		char[] values = value.toCharArray();
		System.out.println(values);
		reverseRecursive(values, 0, values.length - 1);
		System.out.println(values);
	}
}
