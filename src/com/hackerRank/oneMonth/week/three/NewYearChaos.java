package com.hackerRank.oneMonth.week.three;

import java.util.List;

public class NewYearChaos {
	/*
	 * Complete the 'minimumBribes' function below.
	 *
	 * The function accepts INTEGER_ARRAY q as parameter.
	 */
	public static void minimumBribes(List<Integer> q) {
		int minimumBribes = 0;
		for (int i = 0; i < q.size(); i++) {
			if (q.get(i) - 2 > i + 1) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = i - 1; j >= q.get(i) - 2 && j >= 0; j--) {
				if (q.get(j) > q.get(i)) {
					minimumBribes++;
				}
			}
		}
		System.out.println(minimumBribes);
	}
}
