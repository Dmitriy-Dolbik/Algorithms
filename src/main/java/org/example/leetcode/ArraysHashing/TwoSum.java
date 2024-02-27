package org.example.leetcode.ArraysHashing;

import org.example.leetcode.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum implements Task {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsAndTheirIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int secondNumber = target - currentNumber;
            if (numsAndTheirIndices.containsKey(secondNumber)) {
                return new int[]{i, numsAndTheirIndices.get(secondNumber)};
            }
            numsAndTheirIndices.put(currentNumber, i);
        }
        return new int[2];
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/two-sum/description/";
    }

    @Override
    public void getMySolution() {//Time complexity: O(n^2)
//       for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[2];
    }

    @Override
    public void getOptimizeSolution() {
//        Map<Integer, Integer> numsAndTheirIndices = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int currentNumber = nums[i];
//            int secondNumber = target - currentNumber;
//            if (numsAndTheirIndices.containsKey(secondNumber)) {
//                return new int[]{i, numsAndTheirIndices.get(secondNumber)};
//            }
//            numsAndTheirIndices.put(currentNumber, i);
//        }
//        return new int[2];
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";//because we need to create HashMap of n elements
    }
}
