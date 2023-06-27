package com.hackerRank.oneWeek.day.seven;

public class HuffmanDecoding {
	void decode(String s, Node root) {
		/*
		 * A - 1 
		 * B - 00 
		 * C - 01
		 */
		StringBuilder sb = new StringBuilder();
		Node base = root;
		while (!s.isEmpty()) {
			if (s.charAt(0) == '1') {
				base = base.right;
			} else {
				base = base.left;
			}
			s = s.substring(1);
			if (base.left == null && base.right == null) {
				sb.append(base.data);
				base = root;
			}
		}
		System.out.println(sb.toString());
	}

	abstract class Node implements Comparable<Node> {
		public int frequency; // the frequency of this tree
		public char data;
		public Node left, right;

		public Node(int freq) {
			frequency = freq;
		}

		// compares on the frequency
		public int compareTo(Node tree) {
			return frequency - tree.frequency;
		}
	}

	class HuffmanLeaf extends Node {
		public HuffmanLeaf(int freq, char val) {
			super(freq);
			data = val;
		}
	}

	class HuffmanNode extends Node {
		public HuffmanNode(Node l, Node r) {
			super(l.frequency + r.frequency);
			left = l;
			right = r;
		}
	}
}