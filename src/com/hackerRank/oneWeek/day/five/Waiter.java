package com.hackerRank.oneWeek.day.five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Waiter {
    public static List<Integer> waiter(List<Integer> number, int q) {
    	List<Integer> toReturn = new ArrayList<>();
        Stack<Integer> pileA = new Stack<>();
        Stack<Integer> pileB = new Stack<>();
        
        // Initialize pile A with the plates
        for (int plate : number) {
            if (plate % 2 == 0) {
                pileA.push(plate);
            } else {
                pileB.push(plate);
            }
        }
        
        for (int i = 1; i <= q; i++) {
            Stack<Integer> currentPile = (i % 2 == 1) ? pileA : pileB;
            Stack<Integer> nextPile = (i % 2 == 1) ? pileB : pileA;
            
            while (!currentPile.isEmpty()) {
                int plate = currentPile.pop();
                if (i == q) {
                    toReturn.add(plate);
                } else if (plate % getNthPrime(i) == 0) {
                    nextPile.push(plate);
                } else {
                    toReturn.add(plate);
                }
            }
        }
        
        // Add the remaining plates to the result
        while (!pileA.isEmpty()) {
            toReturn.add(pileA.pop());
        }
        while (!pileB.isEmpty()) {
            toReturn.add(pileB.pop());
        }
        Collections.reverse(toReturn);
        
        return toReturn;
        
//        Integer[] resultArray = new Integer[toReturn.size()];
//        for (int i = 0; i < toReturn.size(); i++) {
//            resultArray[i] = toReturn.get(i);
//        }
//        Collections.reverse(Arrays.asList(resultArray));

//        return Arrays.asList(resultArray);
    }

    public static int getNthPrime(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N deve ser maior que 0.");
        }
        if (n == 1) {
            return 2;
        }

        int count = 1;
        int candidate = 1;

        while (count < n) {
            candidate += 2;
            if (isPrime(candidate)) {
                count++;
            }
        }
        return candidate;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
