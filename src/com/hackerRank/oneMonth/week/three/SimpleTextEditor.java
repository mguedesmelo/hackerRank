package com.hackerRank.oneMonth.week.three;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        StringBuilder text = new StringBuilder();
        Stack<Operation> operationStack = new Stack<>();

        for (int i = 0; i < q; i++) {
            int operationType = scanner.nextInt();
            switch (operationType) {
                case 1:
                    // Append operation
                    String appendString = scanner.next();
                    append(text, appendString, operationStack);
                    break;
                case 2:
                    // Delete operation
                    int deleteCount = scanner.nextInt();
                    delete(text, deleteCount, operationStack);
                    break;
                case 3:
                    // Print operation
                    int printIndex = scanner.nextInt();
                    print(text, printIndex);
                    break;
                case 4:
                    // Undo operation
                    undo(text, operationStack);
                    break;
            }
        }

        scanner.close();
    }

    private static void append(StringBuilder text, String appendString, Stack<Operation> operationStack) {
        text.append(appendString);
        operationStack.push(new Operation(OperationType.APPEND, appendString.length()));
    }

    private static void delete(StringBuilder text, int deleteCount, Stack<Operation> operationStack) {
        int startIndex = text.length() - deleteCount;
        String deletedSubstring = text.substring(startIndex);
        text.delete(startIndex, text.length());
        operationStack.push(new Operation(OperationType.DELETE, deletedSubstring));
    }

    private static void print(StringBuilder text, int printIndex) {
        System.out.println(text.charAt(printIndex - 1));
    }

    private static void undo(StringBuilder text, Stack<Operation> operationStack) {
        if (!operationStack.isEmpty()) {
            Operation lastOperation = operationStack.pop();
            switch (lastOperation.getType()) {
                case APPEND:
                    text.delete(text.length() - Integer.valueOf(lastOperation.getArg().toString()), text.length());
                    break;
                case DELETE:
                    text.append(lastOperation.getArg());
                    break;
            }
        }
    }
}

class Operation {
    private OperationType type;
    private Object arg;

    public Operation(OperationType type, Object arg) {
        this.type = type;
        this.arg = arg;
    }

    public OperationType getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }
}

enum OperationType {
    APPEND, DELETE
}
