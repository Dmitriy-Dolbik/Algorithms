package org.example.duplicates;

import java.util.HashSet;
import java.util.Set;

public class DuplicateDetector {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        //Solution 1
//        Map<Integer, Integer> numbersAndTheirCounts = new HashMap<>();
//        for (int number : nums) {
//            int countOfNumbers = numbersAndTheirCounts.getOrDefault(number, 0);
//            if (countOfNumbers >= 1) {
//                return true;
//            }
//            numbersAndTheirCounts.put(number, countOfNumbers + 1);
//        }
//        return false;

        //Solution2
//        Set<Integer> numberSet = new HashSet<>();
//        return Arrays.stream(nums).anyMatch(number -> !numberSet.add(number));
        
        //Solution3
        Set<Integer> numbers = new HashSet<>();
        for (int number : nums) {
           if (!numbers.add(number)) {
               return true;
           }
        }
        return false;
    }
}
