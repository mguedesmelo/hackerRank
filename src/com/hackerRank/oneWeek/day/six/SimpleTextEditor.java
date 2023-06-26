package com.hackerRank.oneWeek.day.six;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		Stack<Operation> operations = new Stack<Operation>();
		int q = sc.nextInt();
		
		int tempInt = 0;
		String tempStr = "";
		int type = 0;
		for (int i = 0; i < q; i++) {
			type = sc.nextInt();
			if (type == 1) {
				tempStr = sc.next();
				sb.append(tempStr);
				operations.push(new Operation(type, tempStr.length()));
			} else if (type == 2) {
				tempInt = sc.nextInt();
				tempStr = sb.substring(sb.length() - tempInt);
				sb.delete(sb.length() - tempInt, sb.length());
				operations.push(new Operation(type, tempStr));
			} else if (type == 3) {
				tempInt = sc.nextInt();
				System.out.println(sb.charAt(tempInt - 1));
			} else {
				Operation operation = operations.pop();
				if (operation.type == 1) {
					sb.delete(sb.length() - (int) operation.argument, sb.length());
				} else {
					sb.append(operation.argument);
				}
			}
		}

		sc.close();
	}
}

class Operation {
	int type;
	Object argument;

	public Operation(int type, Object argument) {
		this.type = type;
		this.argument = argument;
	}
}
