package org.example.leetcode.duplicates;

import org.example.leetcode.Task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class СontainsDuplicate implements Task {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        //интересное решение в две строки
        Set<Integer> numberSet = new HashSet<>();
        return Arrays.stream(nums).anyMatch(number -> !numberSet.add(number));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/contains-duplicate/description/";
    }

    @Override
    public void getMySolution() {
//        Map<Integer, Integer> numbersAndTheirCounts = new HashMap<>();
//        for (int number : nums) {
//            int countOfNumbers = numbersAndTheirCounts.getOrDefault(number, 0);
//            if (countOfNumbers >= 1) {
//                return true;
//            }
//            numbersAndTheirCounts.put(number, countOfNumbers + 1);
//        }
//        return false;
    }

    @Override
    public void getOptimizeSolution() {
//        Set<Integer> numbers = new HashSet<>();
//        for (int number : nums) {
//            if (!numbers.add(number)) {
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";//because we need to create HashSet
    }
}
