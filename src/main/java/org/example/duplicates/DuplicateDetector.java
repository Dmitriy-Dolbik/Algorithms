package org.example.duplicates;

import java.util.HashMap;
import java.util.Map;

public class DuplicateDetector {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numbersAndTheirCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (numbersAndTheirCounts.containsKey(number)) {
                int countOfNumbers = numbersAndTheirCounts.get(number);
                if (countOfNumbers >= 1) {
                    return true;
                }
                numbersAndTheirCounts.put(number, countOfNumbers + 1);
            } else {
                numbersAndTheirCounts.put(number, 1);
            }
        }
        return false;
    }
}
