package com.hackerRank.oneMonth.week.three;

import java.io.BufferedWriter;
import java.io.IOException;

public class ReverseLinkedList {
	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
		if (llist == null) {
			return null;
		}
		SinglyLinkedListNode toReturn = null;
		while (llist != null) {
			SinglyLinkedListNode i = toReturn;
			toReturn = new SinglyLinkedListNode(llist.data);
			toReturn.next = i;
			llist = llist.next;
		}
		return toReturn;
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
		public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
				throws IOException {
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
