package com.hackerRank.oneWeek.day.six;

import java.util.Scanner;

public class LegoBlocks {
	static final int MAX = 1001;
	static final int MODULE = 1000000000 + 7;

	private static int moduleMult(int x, int y) {
		int tempX = x > MODULE ? x % MODULE : x;
		int tempy = y > MODULE ? y % MODULE : y;
		int toReturn = (tempX) * (tempy);

		return toReturn > MODULE ? (toReturn) % MODULE : toReturn;
	}

	private static int getModulePowerOf2(int N) {
		int toReturn = 2;
		for (int i = 1; i <= N - 1; i++) {
			toReturn = toReturn % MODULE;
			toReturn = toReturn << 1;
		}

		return toReturn;
	}

	public static int legoBlocks(int n, int m) {
		int[] arraySolidWall = new int[MAX];
		int[] arrayNMWallCombos = new int[MAX];
		int[] array1MWallCombos = new int[MAX];

		for (int j = 1; j <= m; j++) {
			if (j == 1) {
				array1MWallCombos[j] = 1;
			}
			if (j == 2) {
				array1MWallCombos[j] = 2;
			}
			if (j == 3) {
				array1MWallCombos[j] = 4;
			}
			if (j == 4) {
				array1MWallCombos[j] = 8;
			}
			if (j >= 5) {
				array1MWallCombos[j] = ((array1MWallCombos[j - 1] % MODULE) + (array1MWallCombos[j - 2] % MODULE)
						+ (array1MWallCombos[j - 3] % MODULE) + (array1MWallCombos[j - 4] % MODULE)) % MODULE;
			}

			int temp = 1;
			for (int i = 1; i <= n; i++) {
				temp = moduleMult(array1MWallCombos[j], temp);
			}
			arrayNMWallCombos[j] = temp;
		}

		for (int j = 1; j <= m; j++) {
			if (j == 1) {
				arraySolidWall[j] = 1;
			}
			if (j == 2) {
				arraySolidWall[j] = (getModulePowerOf2(n) - 1) % MODULE;
			}
			if (j == 3) {
				arraySolidWall[j] = (getModulePowerOf2(2 * n) - 2 * getModulePowerOf2(n) + 1) % MODULE;
			}
			if (j == 4) {
				arraySolidWall[j] = ((getModulePowerOf2(3 * n) - 3 * getModulePowerOf2(2 * n) + 3 * getModulePowerOf2(n) - 1))
						% MODULE;
			}
			if (j >= 5) {
				arraySolidWall[j] = arrayNMWallCombos[j];
				for (int i = 1; i <= j - 1; i++) {
					arraySolidWall[j] -= (arraySolidWall[i] * arrayNMWallCombos[j - i]) % MODULE;
				}
			}
			while (arraySolidWall[j] < 0) {
				arraySolidWall[j] += MODULE;
			}
		}
		return arraySolidWall[m];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println(LegoBlocks.legoBlocks(n, m));
		}
		sc.close();
	}
}
