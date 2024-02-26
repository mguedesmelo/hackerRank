package com.hackerRank.oneMonth.week.four;

import java.util.List;

public class ArrayManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Initialize an array to store the cumulative values
        long[] arr = new long[n + 1];

        // Process each query and update the cumulative values
        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            // Add the value to the start index
            arr[a] += k;

            // Subtract the value from the next index after the end index
            if (b + 1 <= n) {
                arr[b + 1] -= k;
            }
        }

        // Compute the cumulative sum and find the maximum value
        long toReturn = 0;
        long currSum = 0;
        for (int i = 1; i <= n; i++) {
            currSum += arr[i];
            toReturn = Math.max(toReturn, currSum);
        }

        return toReturn;
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> queries = List.of(
                List.of(1, 2, 100),
                List.of(2, 5, 200),
                List.of(3, 4, 300)
                // Add more queries as needed
        );

        int n = 5; // Size of the array
        long result = arrayManipulation(n, queries);
        System.out.println("Maximum value in the array: " + result);
    }
}
