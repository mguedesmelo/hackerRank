package com.hackerRank.oneWeek.day.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamParlor {
	/*
	 * Complete the 'icecreamParlor' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER m 2. INTEGER_ARRAY arr
	 */
	public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
		List<Integer> toReturn = new ArrayList<Integer>(0);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			int cost = arr.get(i);
			int diff = m - cost;
			if (diff < 0) {
				continue;
			}
			Integer index = map.get(diff);

			if (index == null) {
				map.put(cost, i + 1);
			} else {
				toReturn.clear();
				toReturn.add(map.get(diff));
				toReturn.add(i + 1);
				break;
			}
		}
		return toReturn;
	}
}
