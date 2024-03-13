package com.hackerRank.oneMonth.week.four;

import java.util.Scanner;

public class BinarySearchTreeLCA {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scanner.nextInt();
			root = insert(root, data);
		}
		int v1 = scanner.nextInt();
		int v2 = scanner.nextInt();
		scanner.close();
		Node ans = lca(root, v1, v2);
		System.out.println(ans.data);
	}

	private static Node insert(Node root, int data) {
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

	private static Node lca(Node root, int v1, int v2) {
		// Decide if call recursively
		
		// Smaller than both
		if (root.data < v1 && root.data < v2) {
			return lca(root.right, v1, v2);
		}
		// Bigger than both
		if (root.data > v1 && root.data > v2) {
			return lca(root.left, v1, v2);
		}

		return root;
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
