package com.hackerRank.oneWeek.day.five;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
	public static void main(String[] args) {
		
	}

    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
 
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            if (stack.isEmpty()) {
                return "NO";
            }
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[') {
                    return "NO";
                }
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[') {
                	return "NO";
                }
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{') {
                	return "NO";
                }
                break;
            }
        }

        return (stack.isEmpty()?"YES":"NO");
    }
}
