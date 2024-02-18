package org.example.duplicates;

import java.util.HashMap;
import java.util.Map;

public class DuplicateDetector {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numbersAndTheirCounts = new HashMap<>();
        for (int number : nums) {
            int countOfNumbers = numbersAndTheirCounts.getOrDefault(number, 0);
            if (countOfNumbers >= 1) {
                return true;
            }
            numbersAndTheirCounts.put(number, countOfNumbers + 1);
        }
        return false;
    }
}
