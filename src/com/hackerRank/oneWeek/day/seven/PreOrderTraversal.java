package com.hackerRank.oneWeek.day.seven;

import java.util.Scanner;
import java.util.Stack;

public class PreOrderTraversal {
	public static void preOrder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node currentNode = stack.pop();
			if (currentNode.right != null) {
				stack.push(currentNode.right);
			}
			if (currentNode.left != null) {
				stack.push(currentNode.left);
			}
			System.out.print(currentNode.data + " ");
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node current;
			if (data <= root.data) {
				current = insert(root.left, data);
				root.left = current;
			} else {
				current = insert(root.right, data);
				root.right = current;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		preOrder(root);
	}
}

class Node {
	Node left;
	Node right;
	int data;
	
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
