package com.hackerRank.oneWeek.day.four;

public class RecursiveDigitSum {
	public static void main(String[] args) {
		System.out.println(RecursiveDigitSum.superDigit("148", 3));
	}

	public static int superDigit(String n, int k) {
        int toReturn = sum(n) * k;
        if (toReturn > 9) {
            toReturn = sum(String.valueOf(toReturn));
        }
        return toReturn;
	}

	private static int sum(String num) {
        int toReturn = 0;
        if (num.length() == 1) {
            return Integer.parseInt(num);
        }
        for (int i = 0; i < num.length(); i++) {
            toReturn += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return sum(String.valueOf(toReturn));
	}
}
