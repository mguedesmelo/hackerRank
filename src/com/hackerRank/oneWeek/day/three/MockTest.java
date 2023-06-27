package com.hackerRank.oneWeek.day.three;

public class MockTest {
	public static void main(String[] args) {
		System.out.println(palindromeIndex("aaab"));
		System.out.println(palindromeIndex("baa"));
		System.out.println(palindromeIndex("aaa"));
	}

	public static int palindromeIndex(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end && s.charAt(start) == s.charAt(end)) {
			start++;
			end--;
		}
		if (start >= end) {
			return -1;
			// already a palindrome
		}
		// We need to delete here
		if (isPalindrome(s, start + 1, end)) {
			return start;
		}
		if (isPalindrome(s, start, end - 1)) {
			return end;
		}
		return -1;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start < end && s.charAt(start) == s.charAt(end)) {
			start++;
			end--;
		}
		return start >= end;
	}
}
