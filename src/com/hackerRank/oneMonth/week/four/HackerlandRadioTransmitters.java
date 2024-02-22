package com.hackerRank.oneMonth.week.four;

import java.util.Collections;
import java.util.List;

public class HackerlandRadioTransmitters {
    public static void main(String[] args) {
        // Sample usage
        List<Integer> x = List.of(1, 2, 3, 4, 5);
        int k = 1;

        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result); // Output: 2
    }

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);

        int transmittersToReturn = 0;
        int i = 0;

        while (i < x.size()) {
            transmittersToReturn++;
            int loc = x.get(i) + k;

            // Move to the rightmost house that can be covered by the transmitter at the current house
            while (i < x.size() && x.get(i) <= loc) {
                i++;
            }

            // Move to the leftmost house that cannot be covered by the current transmitter
            loc = x.get(i - 1) + k;
            while (i < x.size() && x.get(i) <= loc) {
                i++;
            }
        }

        return transmittersToReturn;
    }
}