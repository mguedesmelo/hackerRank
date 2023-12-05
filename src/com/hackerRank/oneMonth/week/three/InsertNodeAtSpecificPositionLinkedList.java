package com.hackerRank.oneMonth.week.three;

import java.io.BufferedWriter;
import java.io.IOException;

public class InsertNodeAtSpecificPositionLinkedList {
	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		SinglyLinkedListNode temp = llist;
		if (llist == null) {
			return node;
		}
		int i = 0;
		while (i < position - 1) {
			temp = temp.next;
			i++;
		}
		node.next = temp.next;
		temp.next = node;
		return llist;
	}

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}
			this.tail = node;
		}
	}

	static class SinglyLinkedListPrintHelper {
		public static void printList(SinglyLinkedListNode node, String sep, 
				BufferedWriter bufferedWriter) throws IOException {
			while (node != null) {
				bufferedWriter.write(String.valueOf(node.data));
				node = node.next;
				if (node != null) {
					bufferedWriter.write(sep);
				}
			}
		}
	}
}
