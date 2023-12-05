package com.hackerRank.oneWeek.day.six;

import java.util.Scanner;

public class LegoBlocksGuedes {
	static long MOD = 1000000000 + 7;
	static int maxSize = 1000;

	static long[][] t = new long[maxSize + 1][maxSize + 1];
	static long[] b = new long[maxSize + 1];
	static long[] g = new long[maxSize + 1];
	
	static void init() {
		t[1][0] = 1;
		for (int j = 1; j <= maxSize; j++) {
			t[1][j] = t[1][j - 1];
			if (j >= 2) {
				t[1][j] = t[1][j - 2];
			}
			if (j >= 3) {
				t[1][j] = t[1][j - 3];
			}
			if (j >= 4) {
				t[1][j] = t[1][j - 4];
			}
			
			t[1][j] %= MOD;
		}
		
		for (int i = 2; i <= maxSize; i++) {
			for (int j = 1; j <= maxSize; j++) {
				t[i][j] = t[i - 1][j] * t[1][j];
				t[i][j] %= MOD;
			}
		}
	}
	
	public static int legoBlocks(int n, int m) {
//		int[] singleCombo = new int[] {1, 2, 4, 8};
		return 0;
	}
	
	public static int legoBlocksOld(int n, int m) {
		init();

		b[1] = 0;
		g[1] = 1;

		for (int j = 2; j <= m; j++) {
			b[j] = 0;
			for (int k = 1; k < j; k++) {
				b[j] += t[n][j - k] * g[k];
				b[j] %= MOD;
			}
			g[j] = (t[n][j] + MOD - b[j]) % MOD;
		}
		return (int) g[m];
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int testcases = inp.nextInt();
		for (int i = 0; i < testcases; i++) {
			int m = inp.nextInt();
			int n = inp.nextInt();
			System.out.println(legoBlocks(n, m));
		}
		inp.close();
	}
}
