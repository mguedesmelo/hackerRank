package com.hackerRank.oneMonth.week.two;

import java.util.List;

public class SalesByMatch {
    public static int sockMerchant(int n, List<Integer> ar) {
    	int toReturn = 0;
        int[] arr = new int[101];
        for (int i = 0; i < ar.size(); i++) {
            arr[ar.get(i)]++;
        }
        for (int i : arr) {
            if (i != 0) {
                toReturn += (i/2);
            }
        }
        return toReturn;
    }
}
