package com.hackerRank.oneWeek.day.four;

import java.util.List;

public class MockTest {
	public static void main(String[] args) {
		
	}

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */
    public static int truckTour(List<List<Integer>> petrolpumps) {
    	final int size = petrolpumps.size();
        for (int start = 0; start < size; start++) {
            if (petrolpumps.get(start).get(0) < petrolpumps.get(start).get(1)) continue;

            long tank = 0;
            int position = start;
            int pumpCount = 0;

            while (true) {
                if (pumpCount == size) {
                    return start;
                }
                if (tank < 0) {
                    break;
                }

                tank += petrolpumps.get(position % size).get(0) - petrolpumps.get(position % size).get(1);
                position++;
                pumpCount++;
            }
        }
        return -1;
    }
}
