package com.hackerRank.oneMonth.week.two;

import java.util.Collections;
import java.util.List;

public class MaxMin {
	public static int maxMin(int k, List<Integer> arr) {
		int toReturn = Integer.MAX_VALUE;
		Collections.sort(arr);
		for (int i = 0; i <= arr.size() - k; i++) {
			toReturn = Math.min(toReturn, arr.get(k + i - 1) - arr.get(i));
		}
		return toReturn;
	}
}
