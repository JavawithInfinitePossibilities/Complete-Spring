/**
 * 
 */
package com.tutorials.java.algorithm.custom.list;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class CustomLinkedList {
	Node head;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	public Node getHead() {
		return head;
	}

	public void reverse(Node head) {
		if (head == null) {
			return;
		}
		reverse(head.next);
		System.out.print(head.data + " ");
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public Integer getNthIndexValue(Node node, int index) {
		Node current = node;
		int counter = 0;
		while (current != null) {
			if (counter == index) {
				return current.data;
			}
			++counter;
			current = current.next;
		}
		return null;
	}

	@Ignore
	public void printReverse() {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);

		linkedList.reverse(linkedList.getHead());
	}

	@Test
	public void getNthValue() {
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.push(1);
		linkedList.push(2);
		linkedList.push(3);
		linkedList.push(4);

		System.out
				.println("Nth index value:" + linkedList.getNthIndexValue(linkedList.getHead(), 1));
	}
}
