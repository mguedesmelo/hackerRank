package com.hackerRank.oneMonth.week.two;

public class SumVersusXor {
    public static long sumXor(long n) {
    	long toReturn = 0;
        while (n != 0) {
            toReturn += (n % 2 == 0)? 1 : 0;
            n /= 2;
        }
        toReturn = (long) Math.pow(2,toReturn);
        return toReturn;
    }
}
