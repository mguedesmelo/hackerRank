package com.hackerRank.oneWeek.day.six;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MockTest {
	public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
		if (n < 1 || edges == null || edges.size() < 1 || s < 1) {
			return null;
		}

		// Step 1
		List<Set<Integer>> tree = new ArrayList<Set<Integer>>();
		for (List<Integer> edge : edges) {
			int a = edge.get(0);
			int b = edge.get(1);
			if (tree.get(a - 1) == null) {
				tree.add(a - 1, new HashSet<Integer>());
			}
			tree.get(a - 1).add(b);
			if (tree.get(b - 1) == null) {
				tree.add(b - 1, new HashSet<Integer>());
			}
			tree.get(b - 1).add(a);
		}

		// Step 2
		List<Integer> toReturn = new ArrayList<Integer>();

		// O(n) start from S
		for (int i = 0; i < n - 1; i++) {
			toReturn.add(-1);
		}

		Set<Integer> root = tree.get(s - 1);
		if (root == null) {
			return toReturn;
		}

		Deque<Integer> queue = new LinkedList<Integer>();
		for (Integer r : root) {
			queue.add(r);
		}
		int height = 1;
		boolean[] visited = new boolean[n];
		visited[s - 1] = true;
		while (!queue.isEmpty()) {
			Deque<Integer> queuen = new LinkedList<Integer>();
			while (!queue.isEmpty()) {
				int v = queue.poll().intValue();
				if (!visited[v - 1]) {
					visited[v - 1] = true;
					// update distances
					if (v > s) {
						toReturn.set(v - 2, height * 6);
					} else {
						toReturn.set(v - 1, height * 6);
					}
					if (tree.get(v - 1) != null) {
						for (Integer r : tree.get(v - 1)) {
							queuen.add(r);
						}
					}
				}
			}
			queue = queuen;
			height++;
		}

		return toReturn;
	}

	public static List<Integer> bfsOld(int n, int m, List<List<Integer>> edges, int s) {
		if (n < 1 || edges == null || edges.size() < 1 || s < 1) {
			return null;
		}

		// Step 1
		List<Set<Integer>> tree = new ArrayList<Set<Integer>>(n);
		for (List<Integer> edge : edges) {
			int a = edge.get(0);
			int b = edge.get(1);
			if (tree.get(a - 1) == null) {
				tree.add(a - 1, new HashSet<Integer>(0));
			}
			tree.get(a - 1).add(b);
			if (tree.get(b - 1) == null) {
				tree.add(b - 1, new HashSet<Integer>(0));
			}
			tree.get(b - 1).add(a);
		}

		// Step 2
		List<Integer> toReturn = new ArrayList<Integer>();
		// O(n^2)
		for (int i = 1; i <= n; i++) {
			if (i == s) {
				continue;
			}
			// find from i to s
			Set<Integer> root = tree.get(i - 1);
			if (root == null) {
				toReturn.add(-1);
				continue;
			}
			Deque<Integer> queue = new LinkedList<Integer>();
			for (Integer r : root) {
				queue.add(r);
			}
			int height = 1;
			boolean[] visited = new boolean[n];
			while (!queue.isEmpty()) {
				Deque<Integer> queuen = new LinkedList<Integer>();
				boolean found = false;
				while (!queue.isEmpty()) {
					int v = queue.poll().intValue();
					if (!visited[v - 1]) {
						visited[v - 1] = true;
						if (v == s) {
							toReturn.add(height * 6);
							found = true;
							break;
						}
						if (tree.get(v - 1) != null) {
							for (Integer r : tree.get(v - 1)) {
								queuen.add(r);
							}
						}
					}
				}

				if (found) {
					break;
				}
				queue = queuen;
				height++;
			}
		}
		return toReturn;
	}

	/**
	 * Represents Node of the graph and contains node id along with the nodes that
	 * are attached to it.
	 *
	 */
//	private static class Node {
//		final int id;
//		final List<Node> linkedNodes = new LinkedList<>();
//
//		private Node(int id) {
//			this.id = id;
//		}
//
//		/**
//		 * Links the input node to this node by adding it to linkedNodes list.
//		 */
////		private void addLinkedNode(Node node) {
////			linkedNodes.add(node);
////		}
//
//		/**
//		 * Gets all the linkedNodes to this node.
//		 */
//		private List<Node> getLinkedNodes() {
//			return linkedNodes;
//		}
//	}

	/**
	 * Calculates the distance between two input nodes.
	 * 
	 * @param N     containing total number of nodes.
	 * @param node1 First node of the nodes to calculate distance between.
	 * @param node2 Second node of the nodes to calculate distance between.
	 * @return distance between two nodes or -1 if nodes are not connected.
	 */
//	private static int calculateDistance(int N, Node node1, Node node2) {
//		// If any of node is null, input nodes are not connected and we return -1.
//		if (node1 == null || node2 == null) {
//			return -1;
//		}
//		// Sets edge length to 6 as mentioned in challenge
//		final int edgeLength = 6;
//
//		// Applies breadth first search (level order traversal) using two queues for
//		// traversing alternate levels starting from level 0 means node1
//		int level = 0;
//
//		// Uses LinkedList as queues since it implements Queue interface and provides
//		// implementation
//		// for queue methods.
//		final Queue<Node> firstQueue = new LinkedList<>();
//		final Queue<Node> secondQueue = new LinkedList<>();
//
//		// Adds node1 to first queue to start loop
//		firstQueue.offer(node1);
//
//		// An array to keep note of visited nodes
//		final boolean[] visitedNodes = new boolean[N];
//
//		while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
//			while (!firstQueue.isEmpty()) {
//				final Node tmpNode = firstQueue.poll();
//				// Ignore the visited nodes
//				if (visitedNodes[tmpNode.id]) {
//					continue;
//				}
//
//				if (tmpNode.id == node2.id) {
//					return level * edgeLength;
//				}
//
//				// mark the current node as visited
//				visitedNodes[tmpNode.id] = true;
//				// add all linked nodes of this node to second queue to traverse after current
//				// queue nodes (this level) have been visited
//				secondQueue.addAll(tmpNode.getLinkedNodes());
//			}
//			// Increment the level as we move to next level after we have traversed all the
//			// elements of a queue
//			level++;
//
//			while (!secondQueue.isEmpty()) {
//				final Node tmpNode = secondQueue.poll();
//				// Ignore the visited nodes
//				if (visitedNodes[tmpNode.id]) {
//					continue;
//				}
//
//				if (tmpNode.id == node2.id) {
//					return level * edgeLength;
//				}
//				// mark the current node as visited
//				visitedNodes[tmpNode.id] = true;
//				// add all linked nodes of this node to first queue to traverse after current
//				// queue nodes (this level) have been visited
//				firstQueue.addAll(tmpNode.getLinkedNodes());
//			}
//			// Increment the level as we move to next level after we have traversed all the
//			// elements of a queue
//			level++;
//		}
//
//		return -1;
//	}
}
