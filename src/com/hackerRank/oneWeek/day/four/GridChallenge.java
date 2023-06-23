package com.hackerRank.oneWeek.day.four;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class ResultGridChallenge {
	public static String gridChallenge(List<String> grid) {
		String firstStr = sort(grid.get(0));
		if (firstStr.length() > 100 || grid.size() > 100) {
			return "NO";
		}
		for (int i = 1; i < grid.size(); i++) {
			String sortedStr = sort(grid.get(i));
			for (int j = 0; j < sortedStr.length(); j++) {
				if (firstStr.charAt(j) > sortedStr.charAt(j)) {
					return "NO";
				}
			}
		}
		return "YES";
	}

	private static String sort(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}

public class GridChallenge {
	public static void main(String[] args) {
		System.out.println(ResultGridChallenge.gridChallenge(Arrays.asList("abc", "ade", "efg")));
		
		System.out.println(ResultGridChallenge.gridChallenge(Arrays.asList("abcde", "fghij", 
				"klmno", "pqrst", "uvwxy")));
	}

    public static void mainHackerRank(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

                String result = ResultGridChallenge.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
