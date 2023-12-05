package com.hackerRank.oneWeek.day.five;

import java.util.Collections;
import java.util.List;

public class MockTest {
    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
    public static int pairs(int k, List<Integer> arr) {
        int toReturn = 0;
        Collections.sort(arr);
        for (Integer i : arr) {
            int numberToSearch = i - k;
            if (binarySearch(arr, numberToSearch)) {
                toReturn++;
            }
        }
        return toReturn;
    }

    private static boolean binarySearch(List<Integer> arr, int numberToFind) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == numberToFind) {
                return true;
            }
            if (arr.get(mid) < numberToFind) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
