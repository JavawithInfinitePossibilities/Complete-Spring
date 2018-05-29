/**
 * 
 */
package com.tutorials.java.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Siddhant sahu
 *
 */
public class LinkedListAlgorithm {
	public int getLength(Node head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	public void display(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

	public int carry = 0;
	// public Node newHead = null;

	public Node addLinkedListForwardOrder1(Node h1, Node h2) {
		int h1Len = getLength(h1);
		int h2Len = getLength(h2);
		int carry = 0;
		if (h1Len > h2Len) {
			int diff = h1Len - h2Len;
			while (diff > 0) {
				Node n = new Node(0);
				n.next = h2;
				h2 = n;
				diff--;
			}
		}
		if (h1Len < h2Len) {
			int diff = h2Len - h1Len;
			while (diff > 0) {
				Node n = new Node(0);
				n.next = h1;
				h1 = n;
				diff--;
			}
		}
		Node tempHead = null;
		Node newHead = addBackRecursion(h1, h2, tempHead);
		while (carry > 0) {
			Node n = new Node(carry);
			n.next = newHead;
			newHead = n;
			--carry;
		}
		return newHead;
	}

	private Node addBackRecursion(Node h1, Node h2, Node tempHead) {
		if (h1 == null && h2 == null) {
			return null;
		}
		tempHead = addBackRecursion(h1.next, h2.next, tempHead);
		int add = h1.data + h2.data + carry;
		carry = 0;
		if (add >= 10) {
			carry = 1;
			add = add % 10;
		}
		Node n = new Node(add);
		if (tempHead == null) {
			tempHead = n;
		} else {
			n.next = tempHead;
			tempHead = n;
		}
		return tempHead;
	}

	@Ignore
	public void testAddLinkedListForwardOrder1() {
		Node h1 = new Node(1);
		h1.next = new Node(0);
		h1.next.next = new Node(0);
		h1.next.next.next = new Node(7);
		System.out.print("First Number : ");
		display(h1);
		Node h2 = new Node(9);
		h2.next = new Node(3);
		System.out.print("\nSecond Number: ");
		display(h2);
		Node x = addLinkedListForwardOrder1(h1, h2);
		System.out.print("\n  Addition: ");
		display(x);
	}

	public Node linkedListAddtionReverseOrder2(Node h1, Node h2) {
		int carry = 0;
		Node newHead = null;
		Node curr = null;
		while (h1 != null && h2 != null) {
			int add = h1.data + h2.data + carry;
			if (add >= 10) {
				carry = 1;
				add = add - 10;
			}
			if (newHead == null) {
				newHead = new Node(add);
				curr = newHead;
			} else {
				Node n = new Node(add);
				curr.next = n;
				curr = curr.next;
			}
			h1 = h1.next;
			h2 = h2.next;
		}
		while (h1 != null) {
			int add = h1.data + carry;
			carry--;
			if (add >= 10) {
				carry = 1;
				add = add - 10;
			}
			Node tempNode = new Node(add);
			curr.next = tempNode;
			curr = curr.next;
			h1 = h1.next;
		}
		while (h2 != null) {
			int add = h2.data + carry;
			carry--;
			if (add >= 10) {
				carry = 1;
				add = add - 10;
			}
			Node tempNode = new Node(add);
			curr.next = tempNode;
			curr = curr.next;
			h2 = h2.next;
		}
		return newHead;
	}

	@Ignore
	public void testLinkedListAddtionReverseOrder2() {
		Node h1 = new Node(5);
		h1.next = new Node(9);
		h1.next.next = new Node(9);
		h1.next.next.next = new Node(7);
		System.out.print(" First Number in REVERSE order: ");
		display(h1);
		Node h2 = new Node(5);
		h2.next = new Node(9);
		System.out.print("\n Second Number in REVERSE order : ");
		display(h2);
		Node x = linkedListAddtionReverseOrder2(h2, h1);
		System.out.print("\n Addition in REVERSE order : ");
		display(x);
	}

	public Node reverseLinkedList3(Node head) {
		Node current = head;
		Node next = null;
		Node previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		return head;
	}

	@Ignore
	public void testReverseLinkedList3() {
		Node head = new Node(5);
		head.next = new Node(8);
		head.next.next = new Node(6);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(2);
		System.out.print(" First Number in REVERSE order: ");
		display(head);
		head = reverseLinkedList3(head);
		System.out.println("___________________");
		display(head);
	}

	public void deleteMiddleNodeInLL4(Node mid) {
		if (mid.next == null) {
			return; // we cant delete the node if it is the last node in the linked list
		}
		Node curr = mid;
		curr.data = curr.next.data;
		curr.next = curr.next.next;
	}

	@Ignore
	public void testDeleteMiddleNodeInLL4() {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		Node mid = new Node(7);
		n.next.next.next.next = mid;
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		System.out.print("Original List : ");
		display(n);
		deleteMiddleNodeInLL4(mid);
		System.out.println("___________________");
		display(n);
	}

	public int KthToLastElementofLL5(Node head, int k) {
		Node first = head;
		Node kthNode = head;
		while (k > 0) {
			--k;
			kthNode = kthNode.next;
		}
		while (kthNode.next != null) {
			first = first.next;
			kthNode = kthNode.next;
		}
		return first.data;
	}

	@Ignore
	public void testKthToLastElementofLL5() {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(7);
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		System.out.print("Original List : ");
		display(n);
		System.out.print(
				"\n Recursion::3rd Element from the end is : " + KthToLastElementofLL5(n, 3));
		System.out.print(
				"\n Iteration::5th Element from the end is : " + KthToLastElementofLL5(n, 5));
	}

	public Node RD6(Node head) {
		Map<Integer, Integer> map = new HashMap<>();
		if (head == null) {
			return null;
		}
		Node current = head.next;
		Node previous = head;
		while (current != null) {
			if (map.containsKey(current.data)) {
				previous.next = current.next;
				current = current.next;
			} else {
				map.put(current.data, 1);
				previous = current;
				current = current.next;
			}
		}
		return head;
	}

	@Ignore
	public void testRD6() {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(2);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(4);
		n.next.next.next.next.next = new Node(4);
		n.next.next.next.next.next.next = new Node(2);
		System.out.print("Original List : ");
		display(n);
		System.out.print("\n Updated List: ");
		Node x = RD6(n);
		display(x);
	}

	public Node mergeTwoLinkList7(Node a, Node b) {
		Node result = null;
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.data < b.data) {
			result = a;
			result.next = mergeTwoLinkList7(a.next, b);
		} else {
			result = b;
			result.next = mergeTwoLinkList7(a, b.next);
		}

		return result;
	}

	@Ignore
	public void testMergeTwoLinkList7() {
		Node n1 = new Node(1);
		n1.next = new Node(3);
		n1.next.next = new Node(5);
		n1.next.next.next = new Node(7);
		Node n2 = new Node(2);
		n2.next = new Node(4);
		n2.next.next = new Node(6);
		n2.next.next.next = new Node(8);
		System.out.println("\nOriginal List : ");
		display(n1);
		System.out.println("\nOriginal List : ");
		display(n1);
		System.out.println("\nMerger List : ");
		display(mergeTwoLinkList7(n1, n2));
	}

	public Node pairwiseSwapNodesByChangingLinks8(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// change the link for first 2 nodes and
		// make a recursive call to rest of the list.
		Node ptrOne = head;
		Node ptrTwo = head.next;
		Node ptrTwoNext = ptrTwo.next;
		ptrTwo.next = head;
		Node newhead = ptrTwo;
		ptrOne.next = pairwiseSwapNodesByChangingLinks8(ptrTwoNext);
		return newhead;
	}

	@Ignore
	public void testPairwiseSwapNodesByChangingLinks8() {
		Node n1 = new Node(1);
		n1.next = new Node(3);
		n1.next.next = new Node(5);
		n1.next.next.next = new Node(7);
		n1.next.next.next.next = null;
		display(pairwiseSwapNodesByChangingLinks8(n1));
	}

	public Node reverseInGrps9(Node head, int grp) {
		int x = grp;
		Node current = head;
		Node next = null;
		Node previous = null;
		while (current != null && x > 0) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			--x;
		}
		if (next != null) {
			head.next = reverseInGrps9(next, grp);
		}
		return previous;
	}

	@Ignore
	public void testReverseInGrps9() {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		Node x = reverseInGrps9(head, 3);
		display(x);
	}

	public Node mergeTwoListAtAlternatePositions10(Node a, Node b) {
		int lenA = 0, lenB = 0;
		Node tempA = a, tempB = b;
		Node temp = null;
		while (tempA != null) {
			lenA++;
			tempA = tempA.next;
		}
		while (tempB != null) {
			lenB++;
			tempB = tempB.next;
		}
		int tempCount = lenA < lenB ? lenA : lenB;
		temp = new Node(a.data);
		a = a.next;
		Node current = temp;
		while (tempCount > 1) {
			int count = 1;
			while (count<3) {
				if (count % 2 == 1) {
					current.next = new Node(b.data);
					current = current.next;
					b = b.next;
				} else {
					current.next = new Node(a.data);
					current = current.next;
					a = a.next;
				}
				count++;
			}
			tempCount--;
		}
		if (a != null) {
			current.next = a;
			current = current.next;
			a = a.next;
		}
		if (b != null) {
			current.next = b;
			current = current.next;
			b = b.next;
		}
		return temp;
	}

	@Ignore
	public void testMergeTwoListAtAlternatePositions10() {
		Node a = new Node(5);
		a.next = new Node(10);
		a.next.next = new Node(15);
		a.next.next.next = new Node(20);
		Node b = new Node(3);
		b.next = new Node(6);
		b.next.next = new Node(9);
		b.next.next.next = new Node(12);
		b.next.next.next.next = new Node(15);
		display(mergeTwoListAtAlternatePositions10(a, b));
	}
}

class Node {
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}