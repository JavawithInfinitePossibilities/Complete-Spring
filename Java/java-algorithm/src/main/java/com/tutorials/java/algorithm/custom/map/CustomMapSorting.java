/**
 * 
 */
package com.tutorials.java.algorithm.custom.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class CustomMapSorting {

	public <K, V extends Comparable<? super V>> Map<K, V> genericSort(Map<K, V> unsortMap) {
		LinkedList<Entry<K, V>> entries = new LinkedList<>(unsortMap.entrySet());
		Collections.sort(entries, new Comparator<Entry<K, V>>() {

			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> sortedMap = new LinkedHashMap<>();
		for (Entry<K, V> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public Map<String, Integer> sortMap(Map<String, Integer> unsortMap) {
		List<Entry<String, Integer>> usSortList = new LinkedList<>(unsortMap.entrySet());
		Collections.sort(usSortList, (Entry<String, Integer> o1, Entry<String, Integer> o2) -> {
			return o1.getValue().compareTo(o2.getValue());
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Entry<String, Integer> entry : usSortList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	@Test
	public void testMapSort() {
		Map<String, Integer> unsortMap = new HashMap<String, Integer>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 2);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("j", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);
		Map<String, Integer> sortedmap = sortMap(unsortMap);
		System.out.println(sortedmap);
	}
}
