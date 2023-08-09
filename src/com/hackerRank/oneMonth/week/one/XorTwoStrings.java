package com.hackerRank.oneMonth.week.one;

import java.util.Scanner;

public class XorTwoStrings {
	public static void main(String[] args) {
//		10101
//		00101
//		10000
		Scanner in = new Scanner(System.in);
		try {
			String s = in.nextLine();
			String t = in.nextLine();
			String value = new String("");
			for (int i = 0; i < s.length(); i++) {
				value += Integer.toString(s.charAt(i) ^ t.charAt(i));
			}
			System.out.println(value);
		} finally {
			in.close();
		}
	}
}
