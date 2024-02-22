package com.hackerRank.oneMonth.week.four;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QHeap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < queries; i++) {
            String operation = scanner.next();

            switch (operation) {
                case "1":
                    int elementToAdd = scanner.nextInt();
                    addToHeap(minHeap, elementToAdd);
                    break;
                case "2":
                    int elementToDelete = scanner.nextInt();
                    deleteFromHeap(minHeap, elementToDelete);
                    break;
                case "3":
                    printMinimum(minHeap);
                    break;
            }
        }

        scanner.close();
    }

    private static void addToHeap(PriorityQueue<Integer> minHeap, int element) {
        minHeap.add(element);
    }

    private static void deleteFromHeap(PriorityQueue<Integer> minHeap, int element) {
        minHeap.remove(element);
    }

    private static void printMinimum(PriorityQueue<Integer> minHeap) {
        System.out.println(minHeap.peek());
    }
}
