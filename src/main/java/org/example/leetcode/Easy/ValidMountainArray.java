package org.example.leetcode.Easy;

import org.example.leetcode.Task;

public class ValidMountainArray implements Task {

    public static boolean validMountainArray(int[] arr) {
        int n = arr.length, leftIndex = 0, rightIndex = n - 1;
        while (leftIndex < n - 1 && arr[leftIndex] < arr[leftIndex + 1]) {
            leftIndex++;
        }
        while (rightIndex > 0 && arr[rightIndex - 1] > arr[rightIndex]) {
            rightIndex--;
        }
        return leftIndex > 0 && rightIndex < n - 1 && leftIndex == rightIndex;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0,3,3,0}));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-mountain-array/description/";
    }

    @Override
    public void getMySolution() {
//        boolean isWasDecreasing = false;
//        boolean isWasIncreasing = false;
//        if (arr.length < 3) return false;
//        for (int i = 1; i < arr.length; i++) {
//            int curr = arr[i];
//            int prev = arr[i-1];
//            if (curr == prev) {
//                return false;
//            }
//            if (curr > prev && isWasDecreasing) {
//                return false;
//            }
//            if (curr < prev && !isWasDecreasing) {
//                isWasDecreasing = true;
//            }
//            if (curr > prev) {
//                isWasIncreasing = true;
//            }
//        }
//        return isWasDecreasing && isWasIncreasing;
    }

    @Override
    public void getOptimizeSolution() {
//        int n = arr.length, leftIndex = 0, rightIndex = n - 1;
//        while (leftIndex < n - 1 && arr[leftIndex] < arr[leftIndex + 1]) {
//            leftIndex++;
//        }
//        while (rightIndex > 0 && arr[rightIndex - 1] > arr[rightIndex]) {
//            rightIndex--;
//        }
//        return leftIndex > 0 && leftIndex == rightIndex && rightIndex < n - 1;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
