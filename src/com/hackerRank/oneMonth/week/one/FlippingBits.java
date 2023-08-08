package com.hackerRank.oneMonth.week.one;

public class FlippingBits {
    public static long flippingBits(long n) {
        n = ~n;
        return n & 0xffffffffL;
    }

	public static void main(String[] args) {
        System.out.println(flippingBits(3l));
        System.out.println(flippingBits(2147483647l));
        System.out.println(flippingBits(1l));
        System.out.println(flippingBits(0l));
	}
}
