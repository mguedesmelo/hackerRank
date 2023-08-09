package com.hackerRank.oneMonth.week.two;

public class CounterGame {
    public static String counterGame(long n) {
    	int turn = 0;
        long current = 2;
        long previous = 2;
        if (n == 1) {
        	return "Louise";
        }
        while (true) {
            if (current == n) {
                n /= 2;
                if (n == 1) {
                    break;
                } else {
                    turn ^= 1;
                    current = 2;
                    previous = 2;
                }
            } else if (current < n) {
                previous = current;
                current *= 2;
                continue;
            } else {
                n = n - previous;
                if (n == 1) {
                    break;
                }
                turn ^= 1;
                current = 2;
                previous = 2;
            }
        }
        return (turn == 1) ? "Richard" : "Louise";
    }
}
