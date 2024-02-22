package com.hackerRank.oneMonth.week.four;

import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
    public static void main(String[] args) {
        // Sample usage
        List<Integer> A = List.of(1, 2, 3, 9, 10, 12);
        int k = 7;

        int result = cookies(k, A);
        System.out.println(result);
    }

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int toReturn = 0;
        while (!minHeap.isEmpty() && minHeap.peek() < k) {
            // If there is only one cookie and its sweetness is still less than k, it's not possible
            if (minHeap.size() < 2) {
                return -1;
            }

            // Combine the two least sweet cookies
            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();
            int newCookie = leastSweet + 2 * secondLeastSweet;

            // Put the new cookie back into the heap
            minHeap.add(newCookie);

            // Increment the operations count
            toReturn++;
        }

        return toReturn;
    }
}