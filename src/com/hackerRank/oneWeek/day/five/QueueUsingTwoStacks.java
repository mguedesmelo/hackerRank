package com.hackerRank.oneWeek.day.five;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new Queue<Integer>();
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				int x = sc.nextInt();
				queue.enqueue(x);
			} else if (type == 2) {
				queue.dequeue();
			} else if (type == 3) {
				System.out.println(queue.peek());
			}
		}
		sc.close();
    }
}

class Queue<T> {
	private Stack<T> stackLeft = new Stack<T>();
	private Stack<T> stackRight = new Stack<T>();

	public void enqueue(T item) {
		stackLeft.push(item);
	}

	public T dequeue() {
		transfer();
		return stackRight.pop();
	}

	public T peek() {
		transfer();
		return stackRight.peek();
	}

	public void transfer() {
		if (stackRight.empty()) {
			while (!stackLeft.empty()) {
				stackRight.push(stackLeft.pop());
			}
		}
	}
}
