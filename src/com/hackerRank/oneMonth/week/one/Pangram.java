package com.hackerRank.oneMonth.week.one;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static String pangrams(String s) {
    	String toReturn = "pangram";
    	int ALPHABET = "abcdefghijklmnopqrstuvwxyz".length();
    	Set<Character> letters = new HashSet<Character>(0);
    	s = s.toLowerCase().replaceAll(" ", "");
    	for (int i = 0; i < s.length(); i++) {
    		letters.add(s.toLowerCase().charAt(i));
    	}
    	if (letters.size() != ALPHABET) {
    		toReturn = "not pangram";
    	}
    	return toReturn;
    }
    
    public static void main(String[] args) {
		System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
		System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
		System.out.println(pangrams("qmExzBIJmdELxyOFWv LOCmefk TwPhargKSPEqSxzveiun"));
	}
}
