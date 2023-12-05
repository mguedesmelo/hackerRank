package com.hackerRank.oneMonth.week.one;

import java.util.Scanner;

public class XorTwoStrings {
	public static void main(String[] args) {
//		10101
//		00101
//		10000
		Scanner in = new Scanner(System.in);
		String value = new String("");
		try {
			String s = "10101"; //in.nextLine();
			String t = "00101"; //in.nextLine();
			for (int i = 0; i < s.length(); i++) {
				value += Integer.toString(s.charAt(i) ^ t.charAt(i));
			}
		} finally {
			in.close();
		}
		System.out.println(value);
	}
}
