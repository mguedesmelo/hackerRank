package com.hackerRank.oneMonth.week.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ClimbingTheLeaderboard {
	/*
	 * Complete the 'climbingLeaderboard' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY ranked 2. INTEGER_ARRAY player
	 */
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		List<Integer> toReturn = new ArrayList<Integer>();
		Set<Integer> rankedTree = new TreeSet<Integer>(ranked);
		Integer[] rankedArray = new Integer[rankedTree.size()];
		int index = 0;
		for (int x : rankedTree) {
			rankedArray[index] = x;
			index++;
		}
		int lastCheckedPosition = 0;
		for (int x : player) {
			if (x >= rankedArray[rankedArray.length - 1]) {
				toReturn.add(1);
			} else {
				for (int i = lastCheckedPosition; i < rankedArray.length; i++) {
					if (x < rankedArray[i]) {
						toReturn.add(rankedArray.length + 1 - i);
						lastCheckedPosition = i;
						break;
					}
					if (x == rankedArray[i]) {
						toReturn.add(rankedArray.length - i);
						lastCheckedPosition = i == 0 ? 0 : i;
						break;
					}
				}
			}
		}
		return toReturn;
	}
}
