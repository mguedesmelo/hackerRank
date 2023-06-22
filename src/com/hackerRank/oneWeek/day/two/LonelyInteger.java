package com.hackerRank.oneWeek.day.two;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class ResultLonelyInteger {
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int lonelyInteger(List<Integer> a) {
        int toReturn = 0;
        Map<Integer, Integer> mapCountByItem = new HashMap<Integer, Integer>(0);
        for (Integer n : a) {
            int v = 1;
            if (mapCountByItem.containsKey(n)) {
                v = mapCountByItem.get(n);
                v++;
            }
            mapCountByItem.put(n, v);
        }
        for (Map.Entry<Integer, Integer> entry : mapCountByItem.entrySet()) {
            if (entry.getValue() <= 1) {
                toReturn = entry.getKey();
            }
        }
        return toReturn;
    }
}

public class LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultLonelyInteger.lonelyInteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
