package com.hackerRank.oneWeek.day.six;

import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {
	public static int cookies(int k, List<Integer> A) {
        int toReturn = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (Integer item : A) {
            q.add(item);
        }

        while (q.size() > 1 && q.peek() <= k) {
            int first = q.poll();
            int second = q.poll();
            q.add(first + 2 * second);
            toReturn++;
        }

        if (q.peek() < k) {
            toReturn = -1;
        }      

        return toReturn;
	}
}
