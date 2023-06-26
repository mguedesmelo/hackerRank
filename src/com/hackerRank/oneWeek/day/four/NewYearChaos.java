package com.hackerRank.oneWeek.day.four;

import java.util.Arrays;
import java.util.List;

public class NewYearChaos {
	public static void main(String[] args) {
		minimumBribes(Arrays.asList(1, 2, 5, 3, 4, 7, 8, 6));

		minimumBribes(Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4));

		minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
	}
	
    public static void minimumBribes(List<Integer> q) {
        int toReturn = 0;
        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) - 2 > i + 1) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = i - 1; j >= q.get(i) - 2 && j >= 0; j--) {
                if (q.get(j) > q.get(i)) {
                    toReturn++;
                }
            }
        }
        System.out.println(toReturn);
    }
}
