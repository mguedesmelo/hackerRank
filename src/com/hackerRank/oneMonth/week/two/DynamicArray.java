package com.hackerRank.oneMonth.week.two;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<Integer> toReturn = new ArrayList<>();
		List<List<Integer>> computation = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			computation.add(new ArrayList<>());
		}

		int lastAnswer = 0;
		for (int i = 0; i < queries.size(); i++) {
			List<Integer> q = queries.get(i);

			if (q.get(0) == 1) {
				computation.get((q.get(1) ^ lastAnswer) % n).add(q.get(2));
			} else {
				List<Integer> seq = computation.get((q.get(1) ^ lastAnswer) % n);
				lastAnswer = seq.get(q.get(2) % seq.size());
				toReturn.add(lastAnswer);
			}
		}

		return toReturn;
	}
}
