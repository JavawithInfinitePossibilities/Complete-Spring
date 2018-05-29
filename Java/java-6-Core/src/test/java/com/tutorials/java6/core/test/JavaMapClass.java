/**
 * 
 */
package com.tutorials.java6.core.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class JavaMapClass {
	public Map<String, String> map = new HashMap<String, String>();
	public String name = new String("siddhant");

	public void method1(Map<String, String> map, String name) {
		map.put("D", "D");
		name = name + "sahu";
		map = null;
		name = null;
	}

	static {
		System.out.println("Welcome...");
	}

	{
		System.out.println("Instance...");
	}

	@Test
	public void testMap() {
		map.put("A", "A");
		map.put("B", "B");
		map.put("C", "C");

		method1(map, name);
		System.out.println(map);
		System.out.println(name);
	}
}
