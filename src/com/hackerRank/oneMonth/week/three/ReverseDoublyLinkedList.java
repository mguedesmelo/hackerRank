package com.hackerRank.oneMonth.week.three;

import java.io.BufferedWriter;
import java.io.IOException;

public class ReverseDoublyLinkedList {
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
    	if (llist == null){
            return null;
        }
        while(llist != null){
        	DoublyLinkedListNode i = llist.prev;
            llist.prev = llist.next;
            llist.next = i;
            if (llist.prev == null){
                return llist;
            }
            llist = llist.prev;
        }
        return llist;
    }
}

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}
