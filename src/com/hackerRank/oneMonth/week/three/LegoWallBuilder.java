package com.hackerRank.oneMonth.week.three;
public class LegoWallBuilder {
    public static void main(String[] args) {
        int height = 3;  // Height of the wall
        int width = 3;   // Width of the wall

        int ways = countWaysToBuildWall(height, width);
        System.out.println("Number of ways to build the wall: " + ways);
    }

    public static int countWaysToBuildWall(int height, int width) {
        int[][] dp = new int[height + 1][width + 1];

        // Initialize base cases
        dp[0][0] = 1;

        // Fill the dp array using the recurrence relation
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                for (int w = 1; w <= 4; w++) {  // Iterate over the 4 types of lego blocks
                    if (j >= w) {
                        dp[i][j] += dp[i - 1][j - w];
                        dp[i][j] %= 1000000007;  // Take the result modulo 10^9 + 7 to avoid overflow
                    }
                }
            }
        }

        return dp[height][width];
    }
}