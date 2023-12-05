package com.hackerRank.oneMonth.week.three;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndTheValidStrings {
    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isValid(String s) {
    	String toReturn = "YES";
    	String tempChar = "";
    	Map<String, Integer> mapStringQuantity = new HashMap<String, Integer>();
    	List<String> list = List.of(s.split(""));
    	for (String ch : list) {
    		int quantity = 1;
    		if (mapStringQuantity.containsKey(ch)) {
    			quantity = mapStringQuantity.get(ch) + 1;
    		}
    		mapStringQuantity.put(ch, quantity);
    		tempChar = ch;
    	}
    	
    	Integer tempValue = mapStringQuantity.get(tempChar);
        for (Map.Entry<String, Integer> entry : mapStringQuantity.entrySet()) {
        	if (!entry.getValue().equals(tempValue)) {
        		toReturn = "NO";
        		break;
        	}
        }
    	return toReturn;
    }
    
    public static void main(String[] args) {
		System.out.println(isValid("aabbcc"));
		System.out.println(isValid("abccc"));
	}
}
