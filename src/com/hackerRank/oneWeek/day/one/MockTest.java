package com.hackerRank.oneWeek.day.one;

import java.util.Collections;
import java.util.List;

public class MockTest {
	public static void main(String[] args) {
		fizzBuzz(15);
	}
	
    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        
        return arr.get(arr.size()/2);
    }
	
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            doFizzBuzz(i);
        }
    }
    
    private static void doFizzBuzz(int n) {
        int sumDigits = sumDigits(String.valueOf(n));
        boolean isDivByThree = (sumDigits % 3 == 0);
        boolean isDivByFive = ((n % 5 == 0) || (n % 5 == 5));

        if (isDivByThree && isDivByFive) {
            System.out.println("FizzBuzz");
            return;
        }
        if (!isDivByThree && !isDivByFive) {
            System.out.println(n);
            return;
        }
        if (isDivByThree && !isDivByFive) {
            System.out.println("Fizz");
            return;
        } 
        if (!isDivByThree && isDivByFive) {
            System.out.println("Buzz");
        } 
    }

    private static int sumDigits(String num) {
        int toReturn = 0;
        if (num.length() == 1) {
            return Integer.parseInt(num);
        }
        for (int i = 0; i < num.length(); i++) {
            toReturn += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return toReturn;
    }
}