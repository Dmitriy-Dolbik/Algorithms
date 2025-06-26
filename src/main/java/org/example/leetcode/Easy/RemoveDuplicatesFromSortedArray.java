package org.example.leetcode.Easy;

import org.example.leetcode.Task;

public class RemoveDuplicatesFromSortedArray implements Task {

    public static int removeDuplicates(int[] nums) {
        int indexOfLastUniqElement = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[indexOfLastUniqElement] != nums[i]) {
                indexOfLastUniqElement++;
                nums[indexOfLastUniqElement] = nums[i];
            }
        }
        return indexOfLastUniqElement + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{-1,0,0,0,0,3,3}));
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/";
    }

    @Override
    public void getMySolution() {
//        int indexOfLastUniqElement = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[indexOfLastUniqElement] != nums[i]) {
//                indexOfLastUniqElement++;
//                nums[indexOfLastUniqElement] = nums[i];
//            }
//        }
//        return indexOfLastUniqElement + 1;
    }

    @Override
    public void getOptimizeSolution() {

    }

    @Override
    public String getTimeComplexity() {
        return "O(n)"; //Т.к. мы один раз проходимся по элементам массива
    }

    @Override
    public String getSpaceComplexity() {
        return "О(1)";//т.к. мы используем только дополнительные переменные
    }
}
