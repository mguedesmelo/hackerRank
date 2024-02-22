package com.hackerRank.oneMonth.week.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Waiter {
	public static void main(String[] args) {
        List<Integer> plates = Arrays.asList(12, 5, 8, 17, 21, 4, 9);
        int iterations = 3;

        List<Integer> result = waiter(plates, iterations);
        System.out.println("Result: " + result);
    }

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Stack<Integer>> piles = new ArrayList<>();
        List<Stack<Integer>> stacks = new ArrayList<>();
        List<Integer> toReturn = new ArrayList<>();

        piles.add(new Stack<>());
        piles.get(0).addAll(number);

        for (int i = 0; i < q; i++) {
            int prime = getNthPrime(i + 1);
            stacks.add(new Stack<>());

            while (!piles.get(i).isEmpty()) {
                int plate = piles.get(i).pop();
                if (plate % prime == 0) {
                    stacks.get(i).push(plate);
                } else {
                    // Ensure there are enough piles for the next iteration
                    if (piles.size() <= i + 1) {
                        piles.add(new Stack<>());
                    }
                    piles.get(i + 1).push(plate);
                }
            }

            while (!stacks.get(i).isEmpty()) {
                toReturn.add(stacks.get(i).pop());
            }
        }

        // Flatten the remaining piles to the result
        for (Stack<Integer> pile : piles) {
            while (!pile.isEmpty()) {
                toReturn.add(pile.pop());
            }
        }

        return toReturn;
    }

    private static int getNthPrime(int n) {
        int count = 0;
        int toReturn = 2;

        while (count < n) {
            if (isPrime(toReturn)) {
                count++;
            }
            if (count < n) {
                toReturn++;
            }
        }

        return toReturn;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
