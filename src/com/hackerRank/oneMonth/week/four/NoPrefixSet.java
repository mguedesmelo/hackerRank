package com.hackerRank.oneMonth.week.four;

import java.util.List;

public class NoPrefixSet {
	public static void noPrefix(List<String> words) {
		TrieNode root = new TrieNode();
		boolean isBadSet = false;

		for (String word : words) {
			if (insertWord(root, word)) {
				isBadSet = true;
				System.out.println("BAD SET");
				System.out.println(word);
				break;
			}
		}

		if (!isBadSet) {
			System.out.println("GOOD SET");
		}
	}

	private static boolean insertWord(TrieNode root, String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			int index = ch - 'a';

			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			} else if (current.children[index].isEndOfWord) {
				return true; // Prefix found
			}

			current = current.children[index];
		}

		current.isEndOfWord = true;

		for (TrieNode child : current.children) {
			if (child != null) {
				return true; // Prefix found
			}
		}

		return false; // No prefix found
	}

	public static void main(String[] args) {
		// Example usage:
		List<String> words1 = List.of("abc", "ab", "bcd");
		noPrefix(words1);

		List<String> words2 = List.of("abc", "def", "ab", "bcd");
		noPrefix(words2);
	}
}

class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;

	TrieNode() {
		children = new TrieNode[26];
		isEndOfWord = false;
	}
}
