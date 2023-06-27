package com.hackerRank.oneWeek.day.two;

import java.util.List;

public class MockTest {
	public static void main(String[] args) {
		
	}

	/*
	 * Complete the 'flippingMatrix' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY matrix as parameter.
	 */
	public static int flippingMatrix(List<List<Integer>> matrix) {
		int toReturn = 0;
		for (int i = 0; i < matrix.size() / 2; i++) {
			for (int j = 0; j < matrix.size() / 2; j++) {
				toReturn += Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(matrix.size() - 1 - j),
						Math.max(matrix.get(matrix.size() - 1 - i).get(j), matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j))));
			}
		}
		return toReturn;
	}
}
