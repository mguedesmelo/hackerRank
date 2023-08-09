package com.hackerRank.oneMonth.week.two;

import java.util.List;

public class SherlockAndArray {
	public static String balancedSums(List<Integer> arr) {
        int totalTotal = 0;
        int runningTotal = 0;
        for (Integer i : arr) {
        	totalTotal += i;
        }

        for (Integer i : arr) {
            totalTotal -= i;
            if (runningTotal == totalTotal) {
                return "YES";
            }
            runningTotal += i;
        }
        return "NO";
	}
}
