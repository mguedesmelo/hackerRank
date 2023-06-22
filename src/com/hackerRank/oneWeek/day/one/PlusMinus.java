package com.hackerRank.oneWeek.day.one;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class ResultPlusMinus {
	/*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        float p = 0;
        float n = 0;
        float z = 0;
        for (int i = 0; i < arr.size(); i++) {
            int value = arr.get(i);
            if (value == 0) {
                z++;
            } else {
                if (value > 0) {
                    p++;
                } else {
                    n++;
                }
            }
        }
        p /= arr.size();
        n /= arr.size();
        z /= arr.size();
        System.out.println(p);
        System.out.println(n);
        System.out.println(z);
    }
}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}
