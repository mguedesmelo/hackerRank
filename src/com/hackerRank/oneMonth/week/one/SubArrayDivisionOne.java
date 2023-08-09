package com.hackerRank.oneMonth.week.one;

import java.util.List;

public class SubArrayDivisionOne {
    public static int birthday(List<Integer> s, int d, int m) {
        int toReturn = 0;
        for (int i = 0; i < s.size(); i++) {
            int sum = 0;
            for (int j = i; j < m + i; j++) {
                if (j == s.size()) {
                    break;
                }

                sum = sum + s.get(j);
            }
            if (sum == d) {
                toReturn++;
            }
        }
        return toReturn;
    }
}
