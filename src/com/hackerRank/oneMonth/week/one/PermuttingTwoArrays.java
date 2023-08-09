package com.hackerRank.oneMonth.week.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuttingTwoArrays {
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
    	String toReturn = "YES";
    	Collections.sort(A);
    	Collections.sort(B);

        for (int i = 0, j = A.size() - 1; i < A.size(); i++, j--) {
            if (A.get(i) + B.get(j) < k) {
            	toReturn = "NO";
            	break;
            }
        }
        
        return toReturn;
    }
    
    public static void main(String[] args) {
		System.out.println(twoArrays(2, Arrays.asList(2, 1, 3), Arrays.asList(7, 8, 9)));
		System.out.println(twoArrays(5, Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 3, 3, 4)));
	}
}
